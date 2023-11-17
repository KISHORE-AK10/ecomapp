package com.cg.ecomapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecomapp.dto.ProductDTO;
import com.cg.ecomapp.entity.Product;
import com.cg.ecomapp.exception.ProductNotFoundException;
import com.cg.ecomapp.exception.ResourceNotFoundException;
import com.cg.ecomapp.repository.ProductRepository;
import com.cg.ecomapp.util.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository proRes;
	
	@Override
	public ProductDTO saveProduct(ProductDTO productDto) {
		// TODO Auto-generated method stub
		
		Product product = ProductMapper.dtoToEntity(productDto);
		Product newProduct = proRes.save(product);
		ProductDTO newProductDto = ProductMapper.entityToDto(newProduct);
		return newProductDto;
	}

	@Override
	public ProductDTO getProductById(int productId) throws ProductNotFoundException{
		// TODO Auto-generated method stub
		Optional<Product> optPro = proRes.findById(productId);
		if(optPro.isEmpty()) {
			// will throw defined exception
			throw new ResourceNotFoundException("Product not found with id: "+productId);
		}
		Product product = optPro.get();
		ProductDTO productDto = ProductMapper.entityToDto(product);
		return productDto;
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> productList = proRes.findAll();
		List<ProductDTO> productDtoList = ProductMapper.entityListToDtoList(productList);
		return productDtoList;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDto) {
		// TODO Auto-generated method stub
		Optional<Product> optPro = proRes.findById(productDto.getProductId());
		if(optPro.isEmpty()) {
			throw new ResourceNotFoundException("Product not found with id: "+productDto.getProductId());
		}
		Product product = ProductMapper.dtoToEntity(productDto);
		Product updatedProduct = proRes.save(product);
		ProductDTO updatedProductDto = ProductMapper.entityToDto(updatedProduct);
		return updatedProductDto;
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> optPro = proRes.findById(productId);
		if(optPro.isEmpty()) {
			throw new ResourceNotFoundException("Product not found with id: "+productId);
		}
		Product product = optPro.get();
		proRes.delete(product);
	}

	@Override
	public ProductDTO findProductDetailsByName(String productName) {
		// TODO Auto-generated method stub
		Optional<Product> optPro = proRes.findByProductName(productName);
		if(optPro.isEmpty()) {
			throw new ResourceNotFoundException("Product not found with name: "+productName);
		}
		Product product = optPro.get();
		ProductDTO productDto = ProductMapper.entityToDto(product);
		return productDto;
	}

	@Override
	public List<ProductDTO> filterProductByCategory(String category) {
		// TODO Auto-generated method stub
		List<Product> product = proRes.findByCategory(category);
		if(product.size() == 0) {
			throw new ResourceNotFoundException("Products not found with category: "+category);
		}
		List<ProductDTO> productDtoList = ProductMapper.entityListToDtoList(product);
		return productDtoList;
	}

	@Override
	public List<ProductDTO> filterProductsUnderPrice(double price) {
		// TODO Auto-generated method stub
		List<Product> product = proRes.getProductsUnderPrice(price);
		if(product.size() == 0) {
			throw new ResourceNotFoundException("Products not found under price: "+price);
		}
		List<ProductDTO> productDtoList = ProductMapper.entityListToDtoList(product);
		return productDtoList;
	}

	@Override
	public List<ProductDTO> filterProductsByPriceRange(double lowerPrice, double upperPrice) {
		// TODO Auto-generated method stub
		List<Product> product = proRes.getProductsWithInPriceRange(lowerPrice, upperPrice);
		if(product.size() == 0) {
			throw new ResourceNotFoundException("Products not found from price "+lowerPrice+" and "+upperPrice);
		}
		List<ProductDTO> productDtoList = ProductMapper.entityListToDtoList(product);
		return productDtoList;
	}

}

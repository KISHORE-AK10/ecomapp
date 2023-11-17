package com.cg.ecomapp.util;

import java.util.ArrayList;
import java.util.List;

import com.cg.ecomapp.dto.ProductDTO;
import com.cg.ecomapp.entity.Product;

public class ProductMapper {

	//convert Product entity to dto
	public static ProductDTO entityToDto(Product product) {
		ProductDTO productDto = new ProductDTO();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setProductPrice(product.getProductPrice());
		productDto.setProductmfd(product.getProductmfd());
		productDto.setCategory(product.getCategory());
		
		return productDto;
	}
	
	//convert Customer dto to entity
	public static Product dtoToEntity(ProductDTO productDto) {
		Product product = new Product();
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setProductPrice(productDto.getProductPrice());
		product.setProductmfd(productDto.getProductmfd());
		product.setCategory(productDto.getCategory());
		
		return product;
	}
	
	//convert Customer entity list to dto list
	public static List<ProductDTO> entityListToDtoList(List<Product> productList){
		List<ProductDTO> productDtoList = new ArrayList<>();
		for(Product product : productList) {
			ProductDTO productDto = entityToDto(product);
			productDtoList.add(productDto);
		}
		
		return productDtoList;
	}
	
	//convert Customer dto list to entity list
	public static List<Product> dtoListToEntityList(List<ProductDTO> productDtoList){
		List<Product> productList = new ArrayList<>();
		for(ProductDTO productDto : productDtoList) {
			Product product = dtoToEntity(productDto);
			productList.add(product);
		}
		
		return productList;
	}
}

package com.cg.ecomapp.service;

import java.util.List;

import com.cg.ecomapp.dto.ProductDTO;

public interface ProductService {

	ProductDTO saveProduct(ProductDTO productDto);
	
	ProductDTO getProductById(int productId);
	
	List<ProductDTO> getAllProduct();
	
	ProductDTO updateProduct(ProductDTO productDto);
	
	void deleteProduct(int productId);
	
	ProductDTO findProductDetailsByName(String productName);
	
	List<ProductDTO> filterProductByCategory(String category);
	
	List<ProductDTO> filterProductsUnderPrice(double price);
	
	List<ProductDTO> filterProductsByPriceRange(double lowerPrice, double upperPrice);
}

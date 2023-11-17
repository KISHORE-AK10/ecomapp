package com.cg.ecomapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecomapp.dto.ProductDTO;
import com.cg.ecomapp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService proSer;
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductDTO>> fetchAllProducts(){
		return new ResponseEntity<>(proSer.getAllProduct(),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String>  addProduct(@Valid @RequestBody ProductDTO productDto) {
		proSer.saveProduct(productDto);
		return new ResponseEntity<>("new Product is added", HttpStatus.CREATED);
	}
	
	@GetMapping("/get{id}")
	public ResponseEntity<ProductDTO>  fetchProductDetailsById(@PathVariable("id") int productId) {
		return new ResponseEntity<>(proSer.getProductById(productId),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ProductDTO> modifyProductDetails(@RequestBody ProductDTO productDto){
		return new ResponseEntity<>(proSer.updateProduct(productDto),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") int productId) {
		proSer.deleteProduct(productId);
		return new ResponseEntity<>("Product Deleted with id: "+productId,HttpStatus.ACCEPTED);
	}
	@GetMapping("/get/name/{name}")
	public ResponseEntity<ProductDTO> fetchProductDetailsByName(@PathVariable("name") String name){
		return new ResponseEntity<>(proSer.findProductDetailsByName(name), HttpStatus.ACCEPTED);
	}
	@GetMapping("/get/category/{category}")
	public ResponseEntity<List<ProductDTO>> fetchProductsByCategory(@PathVariable("category") String category){
		return new ResponseEntity<>(proSer.filterProductByCategory(category), HttpStatus.ACCEPTED);
	}
	@GetMapping("/get/price/{price}")
	public ResponseEntity<List<ProductDTO>> fetchProductsUnderPrice(@PathVariable("price") double price){
		return new ResponseEntity<>(proSer.filterProductsUnderPrice(price),HttpStatus.ACCEPTED);
	}
	@GetMapping("get/lowerPrice/{lowerPrice}/upperPrice/{upperPrice}")
	public ResponseEntity<List<ProductDTO>> fetchProductsWithInPriceRange(@PathVariable("lowerPrice") double lowerPrice, @PathVariable("upperPrice") double upperPrice){
		return new ResponseEntity<>(proSer.filterProductsByPriceRange(lowerPrice, upperPrice), HttpStatus.ACCEPTED);
	}
}

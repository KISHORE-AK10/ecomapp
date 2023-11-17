package com.cg.ecomapp.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProductDTO {
	
	private int productId;
	
	@NotNull(message = "ProductName is required")
	
	private String productName;
	
	@Positive(message = "Price should be positive number")
	
	private double productPrice;
	
	
	private LocalDate productmfd;
	
	private String category;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public LocalDate getProductmfd() {
		return productmfd;
	}

	public void setProductmfd(LocalDate productmfd) {
		this.productmfd = productmfd;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}

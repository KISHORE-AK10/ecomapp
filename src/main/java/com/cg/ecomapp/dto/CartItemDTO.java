package com.cg.ecomapp.dto;

public class CartItemDTO {

	private int cartItemId;
	
	private int quantity;
	
	private ProductDTO prod;
	
	private double itemTotal;

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductDTO getProd() {
		return prod;
	}

	public void setProd(ProductDTO prod) {
		this.prod = prod;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	
	
}

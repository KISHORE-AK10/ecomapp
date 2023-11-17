package com.cg.ecomapp.dto;

import java.util.Set;

public class CartDTO {

	private int cartId;
	
	private double totalAmount;
	
	private CustomerDTO cust;
	
	private Set<CartItemDTO> cartItems;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public CustomerDTO getCust() {
		return cust;
	}

	public void setCust(CustomerDTO cust) {
		this.cust = cust;
	}

	public Set<CartItemDTO> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItemDTO> cartItems) {
		this.cartItems = cartItems;
	}
	
}

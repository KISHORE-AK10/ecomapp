package com.cg.ecomapp.service;
 
import com.cg.ecomapp.dto.CartDTO;
import com.cg.ecomapp.dto.ProductDTO;
 
public interface CartService {
 
	CartDTO addItemToCart(CartDTO cartDto, ProductDTO productDto, int quantity); 
	void removeCartItem(int cartItemId);
	CartDTO getCartByCustomerId(int CustId);
}
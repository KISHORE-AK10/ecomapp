package com.cg.ecomapp.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.cg.ecomapp.dto.CartDTO;
//import com.cg.ecomapp.dto.CustomerDTO;
import com.cg.ecomapp.dto.ProductDTO;
import com.cg.ecomapp.payload.CartItemPayload;
import com.cg.ecomapp.service.CartService;
//import com.cg.ecomapp.service.CustomerService;
import com.cg.ecomapp.service.ProductService;
 
@RestController
@RequestMapping("/cart")
public class CartController {
 
	@Autowired
	private CartService cartSer;
	@Autowired
	private ProductService prodSer;
//	@Autowired
//	private CustomerService custSer;
	@PostMapping("/addItem")
	public ResponseEntity<String> addCart(@RequestBody CartItemPayload cartItemPayload){
//		CustomerDTO customerDto = custSer.getCustomerById(cartItemPayload.getCustId());
		CartDTO cartDto = cartSer.getCartByCustomerId(cartItemPayload.getCustId());
		ProductDTO productDto = prodSer.getProductById(cartItemPayload.getProdId());
		int quantity = cartItemPayload.getQuantity();
		cartSer.addItemToCart(cartDto, productDto, quantity);
		return new ResponseEntity<>("Item saved in cart", HttpStatus.CREATED);
	}
	@DeleteMapping("/delete{id}")
	public ResponseEntity<String> deleteCartItemById(@PathVariable("id") int cartItemId){
		cartSer.removeCartItem(cartItemId);
		return new ResponseEntity<>("Cart Item Deleted", HttpStatus.ACCEPTED);
	}
}
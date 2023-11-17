package com.cg.ecomapp.service;
 
import java.util.Optional;
 
//import java.util.Set;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.cg.ecomapp.dto.CartDTO;
import com.cg.ecomapp.dto.ProductDTO;
import com.cg.ecomapp.entity.Cart;
import com.cg.ecomapp.entity.CartItem;
import com.cg.ecomapp.entity.Customer;
import com.cg.ecomapp.entity.Product;
import com.cg.ecomapp.exception.ResourceNotFoundException;
import com.cg.ecomapp.repository.CartItemsRepository;
import com.cg.ecomapp.repository.CartRepository;
import com.cg.ecomapp.repository.CustomerRepository;
import com.cg.ecomapp.repository.ProductRepository;
import com.cg.ecomapp.util.CartMapper;
import com.cg.ecomapp.util.ProductMapper;
 
@Service
public class CartServiceImpl implements CartService {
 
	@Autowired
	private CartRepository cartRes;
	@Autowired
	private CartItemsRepository cartItemsRes;
	@Autowired
	private ProductRepository prodRes;
	@Autowired
	private CustomerRepository custRes;
	
	public CartDTO addItemToCart(CartDTO cartDTO, ProductDTO productDTO, int quantity) {
		// TODO Auto-generated method stub
//		Set<CartItem>  cartItems = cart.getCartItems();
		Cart cart = CartMapper.dtoToEntity(cartDTO);
		Product product = ProductMapper.dtoToEntity(productDTO);
		CartItem cartItem = new CartItem();
//		cartItem.setCartItemId(1);
		cartItem.setProd(product);
		cartItem.setQuantity(quantity);
		double itemTotal = product.getProductPrice()*quantity;
		cartItem.setItemTotal(itemTotal);
		cartItem.setCart(cart);
		cartItemsRes.save(cartItem);
		
		cart.getCartItems().add(cartItem);
		double TotalAmount=0;
		for(CartItem c: cart.getCartItems()) {
			TotalAmount += c.getItemTotal(); 
		}
		cart.setTotalAmount(TotalAmount);
		cartRes.save(cart);
		cartItemsRes.saveAll(cart.getCartItems());
		CartDTO updatedCartDto = CartMapper.entityToDto(cart);
		return updatedCartDto;
	}
	public void removeCartItem(int cartItemId) {
		Optional<CartItem> optCartItem = cartItemsRes.findById(cartItemId);
		if(optCartItem.isEmpty()) {
			throw new ResourceNotFoundException("Cart item is not found with id: "+cartItemId);
		}
		CartItem cartItem = optCartItem.get();
		cartItemsRes.delete(cartItem);
	}
 

	public CartDTO getCartByCustomerId(int CustomerId) {
		// TODO Auto-generated method stub
		Optional<Customer> optCust = custRes.findById(CustomerId);
		if(optCust.isEmpty()) {
			throw new ResourceNotFoundException("Customer not found");
		}
		Customer cust = optCust.get();
		CartDTO cartDto = CartMapper.entityToDto(cust.getCart());
		return cartDto;
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
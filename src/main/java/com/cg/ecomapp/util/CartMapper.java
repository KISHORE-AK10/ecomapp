package com.cg.ecomapp.util;
 
import java.util.HashSet;
import java.util.Set;
 
import com.cg.ecomapp.dto.CartDTO;
import com.cg.ecomapp.dto.CartItemDTO;
import com.cg.ecomapp.dto.CustomerDTO;
import com.cg.ecomapp.entity.Cart;
import com.cg.ecomapp.entity.CartItem;
import com.cg.ecomapp.entity.Customer;
 
public class CartMapper {
 
	// convert Cart entity to DTO
	public static CartDTO entityToDto(Cart cart) {
		CartDTO cartDto = new CartDTO();
		cartDto.setCartId(cart.getCartId());
		cartDto.setTotalAmount(cart.getTotalAmount());
		CustomerDTO customerDto = CustomerMapper.entityToDto(cart.getCust());
		cartDto.setCust(customerDto);
		Set<CartItemDTO> cartItemDtoSet = CartItemMapper.entitySetToDtoSet(cart.getCartItems());
		cartDto.setCartItems(cartItemDtoSet);
 
		return cartDto;
	}
 
	// convert Cart DTO to entity
	public static Cart dtoToEntity(CartDTO cartDto) {
		Cart cart = new Cart();
		cart.setCartId(cartDto.getCartId());
		cart.setTotalAmount(cartDto.getTotalAmount());
		Customer customer = CustomerMapper.dtoToEntity(cartDto.getCust());
		cart.setCust(customer);
		Set<CartItem> cartItemSet = CartItemMapper.dtoSetToEntitySet(cartDto.getCartItems());
		cart.setCartItems(cartItemSet);
 
		return cart;
	}
 
	// convert Customer entity list to DTO list
	public static Set<CartDTO> entitySetToDtoSet(Set<Cart> cartSet) {
		Set<CartDTO> cartDtoSet = new HashSet<>();
		for (Cart cart : cartSet) {
			CartDTO cartDto = entityToDto(cart);
			cartDtoSet.add(cartDto);
		}
 
		return cartDtoSet;
	}
 
	// convert Customer DTO list to entity list
	public static Set<Cart> dtoSetToEntitySet(Set<CartDTO> cartDtoSet) {
		Set<Cart> cartSet = new HashSet<>();
		for (CartDTO cartDto : cartDtoSet) {
			Cart cart = dtoToEntity(cartDto);
			cartSet.add(cart);
		}
 
		return cartSet;
	}
}
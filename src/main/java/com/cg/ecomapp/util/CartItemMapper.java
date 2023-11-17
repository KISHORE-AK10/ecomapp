package com.cg.ecomapp.util;
 
import java.util.HashSet;
import java.util.Set;
 
import com.cg.ecomapp.dto.CartItemDTO;
import com.cg.ecomapp.dto.ProductDTO;
import com.cg.ecomapp.entity.CartItem;
import com.cg.ecomapp.entity.Product;
 
public class CartItemMapper {
 
	//Convert entity to dto
	public static CartItemDTO entityToDto(CartItem cartItem) {
		CartItemDTO cartItemDto = new CartItemDTO();
		cartItemDto.setCartItemId(cartItem.getCartItemId());
		cartItemDto.setQuantity(cartItem.getQuantity());
		cartItemDto.setItemTotal(cartItem.getItemTotal());
		ProductDTO productDto = ProductMapper.entityToDto(cartItem.getProd());
		cartItemDto.setProd(productDto);
		return cartItemDto;
	}
	//Convert dto to entity
	public static CartItem dtoToEntity(CartItemDTO cartItemDto) {
		CartItem cartItem = new CartItem();
		cartItem.setCartItemId(cartItemDto.getCartItemId());
		cartItem.setQuantity(cartItemDto.getQuantity());
		cartItem.setItemTotal(cartItemDto.getItemTotal());
		Product product = ProductMapper.dtoToEntity(cartItemDto.getProd());
		cartItem.setProd(product);
		return cartItem;
	}
	//convert entity Set to dto Set
	public static Set<CartItemDTO> entitySetToDtoSet(Set<CartItem> cartItemSet){
		Set<CartItemDTO> CartItemDtoSet = new HashSet<>();
		for(CartItem cartItem : cartItemSet) {
			CartItemDTO cartItemDto = entityToDto(cartItem);
			CartItemDtoSet.add(cartItemDto);
		}
		return CartItemDtoSet;
	}
	//convert dto Set to entity Set
	public static Set<CartItem> dtoSetToEntitySet(Set<CartItemDTO> CartItemDtoSet){
		Set<CartItem> cartItemSet = new HashSet<>();
		for(CartItemDTO cartItemDto : CartItemDtoSet) {
			CartItem cartItem = dtoToEntity(cartItemDto);
			cartItemSet.add(cartItem);
		}
		return cartItemSet;
	}
}
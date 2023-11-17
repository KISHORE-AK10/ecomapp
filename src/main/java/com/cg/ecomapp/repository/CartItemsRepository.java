package com.cg.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ecomapp.entity.CartItem;

public interface CartItemsRepository extends JpaRepository<CartItem, Integer>{

}

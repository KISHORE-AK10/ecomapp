package com.cg.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ecomapp.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	
}

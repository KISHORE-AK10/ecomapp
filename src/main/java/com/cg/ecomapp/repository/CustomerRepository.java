package com.cg.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ecomapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
}

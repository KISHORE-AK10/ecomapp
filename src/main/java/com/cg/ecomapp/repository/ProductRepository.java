package com.cg.ecomapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.ecomapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Optional<Product> findByProductName(String name);
	
	List<Product> findByCategory(String categoryName);
	
	@Query("select p from Product p where p.productPrice <= :pprice")
	List<Product> getProductsUnderPrice(@Param("pprice") double price);
	
	@Query("select p from Product p where p.productPrice between :plprice and :puprice order by p.productPrice")
	List<Product> getProductsWithInPriceRange(@Param("plprice") double lowerPrice, @Param("puprice") double upperPrice);
}

package com.projectapi.projectapi.shop.repository;

import com.projectapi.projectapi.shop.model.Product;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository 
extends JpaRepository<Product, Long>{
	Product findById(long id);
	
	Product findByName(String name);
	
	Optional<Product> findOpionalById(long id);
}

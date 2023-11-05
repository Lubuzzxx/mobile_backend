package com.projectapi.projectapi.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectapi.projectapi.shop.model.Customer;
import com.projectapi.projectapi.shop.model.Favorite;
import com.projectapi.projectapi.shop.model.Product;

import java.util.List;
import java.util.Optional;



public interface FavoriteRepository 
extends JpaRepository<Favorite, Long>{
	List<Favorite> findByCustomerId(long customerId);
	Favorite findById(long id);
	Optional<Favorite> findOptionalById(long id);
	void deleteByCustomerId(Long customerId);
	Favorite findByCustomerAndProduct(Customer customer, Product product);
}

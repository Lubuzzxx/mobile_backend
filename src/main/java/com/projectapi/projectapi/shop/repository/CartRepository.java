package com.projectapi.projectapi.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectapi.projectapi.shop.model.Cart;
import com.projectapi.projectapi.shop.model.Customer;
import com.projectapi.projectapi.shop.model.Product;


public interface CartRepository 
extends JpaRepository<Cart, Long>{
		List<Cart> findByCustomerId(long customerId);
		Cart findById(long id);
		Optional<Cart> findOptionalById(long id);
		void deleteByCustomerId(Long customerId);
		Cart findByCustomerAndProduct(Customer customer, Product product);
}

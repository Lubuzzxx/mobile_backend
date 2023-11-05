package com.projectapi.projectapi.shop.repository;

import com.projectapi.projectapi.shop.model.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
extends JpaRepository<Customer, Long>{
		Customer findById(long id);
		
		Customer findByEmail(String email);
		
		Customer findByEmailAndPassword(String email, String password);
		
		Optional<Customer> findOpionalById(long id);
}

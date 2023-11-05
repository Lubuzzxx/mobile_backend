package com.projectapi.projectapi.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectapi.projectapi.shop.model.Admin;

public interface AdminRepository 
extends JpaRepository<Admin, Long>{
	Admin findById(long id);
	
	Admin findByEmail(String email);
	
	Admin findByEmailAndPassword(String email, String password);
	
	Optional<Admin> findOpionalById(long id);
	
}

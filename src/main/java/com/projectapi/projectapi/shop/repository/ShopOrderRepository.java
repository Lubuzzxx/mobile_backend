package com.projectapi.projectapi.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectapi.projectapi.shop.model.ShopOrder;

public interface ShopOrderRepository 
extends JpaRepository<ShopOrder,Long>{
	ShopOrder findById(long id);
	List<ShopOrder> findByCustomerId(long id);
	List<ShopOrder> findByStatus(String status);
	
	Optional<ShopOrder> findOptionalById(long id);
}

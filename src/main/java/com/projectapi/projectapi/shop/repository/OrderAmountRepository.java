package com.projectapi.projectapi.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectapi.projectapi.shop.model.OrderAmount;

public interface OrderAmountRepository 
extends JpaRepository<OrderAmount, Long>{
	List<OrderAmount> findByShopOrderId(long shopOrderId);
	OrderAmount findById(long id);
	Optional<OrderAmount> findOptionalById(long id);

}

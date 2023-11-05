package com.projectapi.projectapi.shop.service;

import java.util.List;

import com.projectapi.projectapi.shop.model.Cart;

public interface ICart {
	List<Cart> findAllCarts();
	Cart findById(long id);
	List<Cart> findByCustomerId(long customerId);
	Cart save(Cart enrollment);
	void deleteById(long id);
	void deleteCartsByCustomerId(Long customerId);
}

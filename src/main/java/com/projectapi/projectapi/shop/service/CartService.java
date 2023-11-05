package com.projectapi.projectapi.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.model.Cart;
import com.projectapi.projectapi.shop.repository.CartRepository;

@Service
public class CartService implements ICart{
	
	@Autowired
	CartRepository cartRepository;
	
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public List<Cart> findAllCarts() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}

	@Override
	public List<Cart> findByCustomerId(long id) {
		// TODO Auto-generated method stub
		return cartRepository.findByCustomerId(id);
	}

	@Override
	public Cart save(Cart c) {
		// TODO Auto-generated method stub
		return cartRepository.save(c);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		cartRepository.deleteById(id);
	}

	public Optional<Cart> findOptionalById(long id) {
		return cartRepository.findOptionalById(id);
	}

	@Override
	public Cart findById(long id) {
		// TODO Auto-generated method stub
		return cartRepository.findById(id);
	}

	@Override
	public void deleteCartsByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		cartRepository.deleteByCustomerId(customerId);
	}

}

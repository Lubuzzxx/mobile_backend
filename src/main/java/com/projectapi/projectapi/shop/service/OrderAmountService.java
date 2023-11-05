package com.projectapi.projectapi.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.model.OrderAmount;
import com.projectapi.projectapi.shop.repository.OrderAmountRepository;

@Service
public class OrderAmountService implements IOrderAmount{

	@Autowired
	OrderAmountRepository orderAmountRepository;
	
	public OrderAmountService(OrderAmountRepository orderAmountRepository) {
		this.orderAmountRepository = orderAmountRepository;
	}

	@Override
	public List<OrderAmount> findAllOrderAmounts() {
		// TODO Auto-generated method stub
		return orderAmountRepository.findAll();
	}

	@Override
	public OrderAmount findById(long id) {
		// TODO Auto-generated method stub
		return orderAmountRepository.findById(id);
	}

	@Override
	public List<OrderAmount> findByShopOrderId(long shopOrderId) {
		// TODO Auto-generated method stub
		return orderAmountRepository.findByShopOrderId(shopOrderId);
	}

	@Override
	public OrderAmount save(OrderAmount oa) {
		// TODO Auto-generated method stub
		return orderAmountRepository.save(oa);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		orderAmountRepository.deleteById(id);
	}
	
	public Optional<OrderAmount> findOptionalById(long id) {
		return orderAmountRepository.findOptionalById(id);
	}
	
}

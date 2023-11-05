package com.projectapi.projectapi.shop.service;

import java.util.List;

import com.projectapi.projectapi.shop.model.OrderAmount;

public interface IOrderAmount {
	List<OrderAmount> findAllOrderAmounts();
	OrderAmount findById(long id);
	List<OrderAmount> findByShopOrderId(long shopOrderId);
	OrderAmount save(OrderAmount oa);
	void deleteById(long id);
}

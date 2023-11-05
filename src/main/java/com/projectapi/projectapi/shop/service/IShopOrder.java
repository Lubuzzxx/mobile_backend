package com.projectapi.projectapi.shop.service;

import java.util.List;

import com.projectapi.projectapi.shop.model.ShopOrder;

public interface IShopOrder {
	List<ShopOrder> findAllOrders();
	ShopOrder findById(long id);
	List<ShopOrder> findByCustomerId(long id);
	List<ShopOrder> findByStatus(String status);
	ShopOrder save(ShopOrder so);
	void deleteById(long id);
}

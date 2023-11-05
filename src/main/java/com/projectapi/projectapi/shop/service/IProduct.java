package com.projectapi.projectapi.shop.service;

import java.util.List;

import com.projectapi.projectapi.shop.model.Product;

public interface IProduct {
	List<Product> getAllProducts();
	Product findById(long id);
	Product findByName(String name);
	Product save(Product std);
	void deleteById(long id);
}

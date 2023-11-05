package com.projectapi.projectapi.shop.payload;

import com.projectapi.projectapi.shop.model.Customer;
import com.projectapi.projectapi.shop.model.Product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FavoritePayload {
	private long id;
	private Product product;
	private Customer customer;
}

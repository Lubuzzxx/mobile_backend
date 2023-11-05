package com.projectapi.projectapi.shop.payload;

import com.projectapi.projectapi.shop.model.Product;
import com.projectapi.projectapi.shop.model.Customer;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartPayload {
	private long id;
	private Product product;
	private Customer customer;
	private int amount;
}

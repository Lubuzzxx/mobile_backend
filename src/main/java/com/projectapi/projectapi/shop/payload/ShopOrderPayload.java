package com.projectapi.projectapi.shop.payload;

import com.projectapi.projectapi.shop.model.Customer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShopOrderPayload {
	private int totalPrice;
	private Customer customer;
	private String deliver;
	private String payMethod;
	private String receipt;
	private String status;
}

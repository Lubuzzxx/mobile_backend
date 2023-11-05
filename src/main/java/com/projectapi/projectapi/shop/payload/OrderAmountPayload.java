package com.projectapi.projectapi.shop.payload;

import com.projectapi.projectapi.shop.model.ShopOrder;
import com.projectapi.projectapi.shop.model.Product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderAmountPayload {
	private Product product;
	private ShopOrder shopOrder;
	private int amount;
}

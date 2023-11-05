package com.projectapi.projectapi.shop.json;

import com.projectapi.projectapi.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

import com.projectapi.projectapi.shop.model.Cart;
import com.projectapi.projectapi.shop.model.Customer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CartListJson {
	private long id;
	private Product product;
	private Customer customer;
	private int amount;
	
	public static CartListJson packJson(Cart cart) {
		CartListJson clj = new CartListJson();
		clj.setId(cart.getId());
		clj.setProduct(cart.getProduct());
		clj.setCustomer(cart.getCustomer());
		clj.setAmount(cart.getAmount());
		return clj;
	}
	
	public static List<CartListJson> packJsons(List<Cart> carts){
		List<CartListJson> clj = new ArrayList<CartListJson>();
		for(Cart cart : carts) {
			clj.add(packJson(cart));
		}
		return clj;
	}
}

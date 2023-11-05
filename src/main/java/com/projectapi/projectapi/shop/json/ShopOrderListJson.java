package com.projectapi.projectapi.shop.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.projectapi.projectapi.shop.model.Customer;
import com.projectapi.projectapi.shop.model.ShopOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ShopOrderListJson {
	private long id;
	private LocalDateTime orderAt;
	private int totalPrice;
	private Customer customer;
	private String deliver;
	private String payMethod;
	private String receipt;
	private String status;
	
	public static ShopOrderListJson packJson(ShopOrder shopOrder) {
		ShopOrderListJson olj = new ShopOrderListJson();
		olj.setId(shopOrder.getId());
		olj.setOrderAt(shopOrder.getOrderAt());
		olj.setTotalPrice(shopOrder.getTotalPrice());
		olj.setCustomer(shopOrder.getCustomer());
		olj.setDeliver(shopOrder.getDeliver());
		olj.setPayMethod(shopOrder.getPayMethod());
		olj.setReceipt(shopOrder.getReceipt());
		olj.setStatus(shopOrder.getStatus());
		return olj;
	}
	
	public static List<ShopOrderListJson> packJson(List<ShopOrder> shopOrders){
		List<ShopOrderListJson> solj = new ArrayList<ShopOrderListJson>();
		for(ShopOrder shopOrder : shopOrders) {
			solj.add(packJson(shopOrder));
		}
		return solj;
	}

}

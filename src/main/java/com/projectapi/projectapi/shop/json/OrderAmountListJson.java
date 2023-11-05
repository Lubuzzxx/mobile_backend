package com.projectapi.projectapi.shop.json;

import java.util.ArrayList;
import java.util.List;

import com.projectapi.projectapi.shop.model.OrderAmount;
import com.projectapi.projectapi.shop.model.Product;
import com.projectapi.projectapi.shop.model.ShopOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderAmountListJson {
	private Product product;
	private ShopOrder shopOrder;
	private int amount;
	
	public static OrderAmountListJson packJson(OrderAmount oa) {
		OrderAmountListJson oalj = new OrderAmountListJson();
		oalj.setProduct(oa.getProduct());
		oalj.setShopOrder(oa.getShopOrder());
		oalj.setAmount(oa.getAmount());
		return oalj;
	}
	
	public static List<OrderAmountListJson> packJsons(List<OrderAmount> orderAmounts){
		List<OrderAmountListJson> oalj = new ArrayList<OrderAmountListJson>();
		for(OrderAmount oa : orderAmounts) {
			oalj.add(packJson(oa));
		}
		return oalj;
	}
}

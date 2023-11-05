package com.projectapi.projectapi.shop.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.json.OrderAmountListJson;
import com.projectapi.projectapi.shop.model.OrderAmount;
import com.projectapi.projectapi.shop.payload.OrderAmountPayload;
import com.projectapi.projectapi.shop.service.OrderAmountService;

@Service
public class OrderAmountBusiness {

	@Autowired
	OrderAmountService orderAmountService;
	
	public List<OrderAmountListJson> getListOrderAmounts() {
		return OrderAmountListJson.packJsons(orderAmountService.findAllOrderAmounts());
	}
	
	public List<OrderAmountListJson> getOrderAmountByShopOrderId(long id) {
		return OrderAmountListJson.packJsons(orderAmountService.findByShopOrderId(id));
	}
	
	public void saveOrderAmount(OrderAmountPayload oa) {
		OrderAmount orderAmount = new OrderAmount(
				oa.getProduct(),
				oa.getShopOrder(),
				oa.getAmount());
		orderAmountService.save(orderAmount);
	}
	
	public void updateOrderAmount(long id, OrderAmountPayload payload) {
		OrderAmount oaData = orderAmountService.findById(id);
		oaData.setProduct(payload.getProduct());
		oaData.setShopOrder(payload.getShopOrder());
		oaData.setAmount(payload.getAmount());
		orderAmountService.save(oaData);
	}
	
	public void deleteOrderAmount(long id) {
		orderAmountService.deleteById(id);
	}
	
}

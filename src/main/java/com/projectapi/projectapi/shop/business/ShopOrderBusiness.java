package com.projectapi.projectapi.shop.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.json.ShopOrderListJson;
import com.projectapi.projectapi.shop.model.Cart;
import com.projectapi.projectapi.shop.model.OrderAmount;
import com.projectapi.projectapi.shop.model.ShopOrder;
import com.projectapi.projectapi.shop.payload.ShopOrderPayload;
import com.projectapi.projectapi.shop.repository.CartRepository;
import com.projectapi.projectapi.shop.repository.OrderAmountRepository;
import com.projectapi.projectapi.shop.service.CartService;
import com.projectapi.projectapi.shop.service.ShopOrderService;

@Service
public class ShopOrderBusiness {

	@Autowired
	ShopOrderService shopOrderService;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	OrderAmountRepository orderAmountRepository;
	
	public List<ShopOrderListJson> getListShopOrder() {
		return ShopOrderListJson.packJson(shopOrderService.findAllOrders());
	}
	
	public ShopOrderListJson getOrderById(long id) {
		return ShopOrderListJson.packJson(shopOrderService.findById(id));
	}
	
	public List<ShopOrderListJson> getOrderByCustomerId(long id) {
		return ShopOrderListJson.packJson(shopOrderService.findByCustomerId(id));
	}
	
	public List<ShopOrderListJson> getStatus(String status) {
		return ShopOrderListJson.packJson(shopOrderService.findByStatus(status));
	}
	
	public void saveShopOrder(ShopOrderPayload opl) {
		ShopOrder so = new ShopOrder(
				opl.getTotalPrice(),
				opl.getCustomer(),
				opl.getDeliver(),
				opl.getPayMethod(),
				opl.getReceipt(),
				opl.getStatus());
		ShopOrder savedOrder = shopOrderService.save(so);
		Long OrderId = savedOrder.getId();
		Long customerId = savedOrder.getCustomer().getId();
		List<Cart> cartItems = cartRepository.findByCustomerId(customerId);
		for (Cart cartItem : cartItems) {
          OrderAmount orderAmount = new OrderAmount();
          orderAmount.setProduct(cartItem.getProduct());
          orderAmount.setShopOrder(savedOrder);
          orderAmount.setAmount(cartItem.getAmount());

          orderAmountRepository.save(orderAmount);
      }
//		cartRepository.deleteByCustomerId(customerId);
//		cartService.deleteByCustomerId(customerId);
//		cartService.deleteCartsByCustomerId(customerId);
//		return customerId;
	}
	
	public void updateShopOrder(long id, ShopOrderPayload payload) {
		ShopOrder oData = shopOrderService.findById(id);
		oData.setTotalPrice(payload.getTotalPrice());
		oData.setCustomer(payload.getCustomer());
		oData.setDeliver(payload.getDeliver());
		oData.setPayMethod(payload.getPayMethod());
		oData.setReceipt(payload.getReceipt());
		oData.setStatus(payload.getStatus());
		shopOrderService.save(oData);
	}
	
	public void deleteShopOrder(long id) {
		shopOrderService.deleteById(id);
	}
	
}

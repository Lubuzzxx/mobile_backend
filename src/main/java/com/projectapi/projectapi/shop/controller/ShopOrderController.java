package com.projectapi.projectapi.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectapi.projectapi.exception.BaseException;
import com.projectapi.projectapi.shop.business.ShopOrderBusiness;
import com.projectapi.projectapi.shop.exception.ShopOrderException;
import com.projectapi.projectapi.shop.json.ShopOrderListJson;
import com.projectapi.projectapi.shop.model.ShopOrder;
import com.projectapi.projectapi.shop.payload.ShopOrderPayload;
import com.projectapi.projectapi.shop.service.ShopOrderService;

@RestController
@RequestMapping("/api")
public class ShopOrderController {

	@Autowired
	ShopOrderService shopOrderService;
	
	@Autowired
	ShopOrderBusiness soBusiness;
	
	public ShopOrderController(ShopOrderService shopOrderService) {
		this.shopOrderService = shopOrderService;
	}
	
	//get all
	@GetMapping(value = "/orders")
	public ResponseEntity<List<ShopOrderListJson>> getAllOrders() throws ShopOrderException {
		return ResponseEntity.ok(soBusiness.getListShopOrder());
	}
	
	//id
	@GetMapping(value = "/orders/id/{id}")
	public ResponseEntity<ShopOrderListJson> getOrderById(@PathVariable("id") long id) throws BaseException {
		return ResponseEntity.ok(soBusiness.getOrderById(id));
	}
	
	//check all status for admin
	@GetMapping(value = "/orders/status/{status}")
	public ResponseEntity<List<ShopOrderListJson>> getOrderByStatus(@PathVariable("status") String order) throws ShopOrderException {
		return ResponseEntity.ok(soBusiness.getStatus(order));
	}
	
	//order each customer
	@GetMapping(value = "/orders/cus/{id}")
	public ResponseEntity<List<ShopOrderListJson>> getOrderByStatus(@PathVariable("id") long id) throws ShopOrderException {
		return ResponseEntity.ok(soBusiness.getOrderByCustomerId(id));
	}
	
	
//	{
//	    "totalPrice" : 1000,
//	    "customer" : {
//	        "id" : 1
//	    },
//	    "deliver" : "post",
//	    "payMethod" : "bankTransfer",
//	    "receipt" : "receipt picture",
//	    "status" : "delivering"
//	}
	//status delivering / delivered
	//deliver post / flash / kerry
	//payMethod bankTransfer / cod 
	@PostMapping(value = "/orders")
	public ResponseEntity<Void> saveOrder(@RequestBody ShopOrderPayload payload) throws ShopOrderException {
		soBusiness.saveShopOrder(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
//		return ResponseEntity.ok(soBusiness.saveShopOrder(payload));
	}
	
	//update
	@PutMapping(value = "/orders/{id}")
	public ResponseEntity<ShopOrderListJson> updateOrder(@PathVariable("id") long id, @RequestBody ShopOrderPayload payload) throws ShopOrderException {
		Optional<ShopOrder> soData = shopOrderService.findOptionalById(id);
		if (soData.isPresent()) {
			soBusiness.updateShopOrder(soData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/orders/{id}")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") long id) throws ShopOrderException {
		try {
			soBusiness.deleteShopOrder(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

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

import com.projectapi.projectapi.shop.business.OrderAmountBusiness;
import com.projectapi.projectapi.shop.exception.OrderAmountException;
import com.projectapi.projectapi.shop.json.OrderAmountListJson;
import com.projectapi.projectapi.shop.model.OrderAmount;
import com.projectapi.projectapi.shop.payload.OrderAmountPayload;
import com.projectapi.projectapi.shop.service.OrderAmountService;

@RestController
@RequestMapping("/api")
public class OrderAmountController {

	@Autowired
	OrderAmountService orderAmountService;
	
	@Autowired
	OrderAmountBusiness oaBusiness;
	
	public OrderAmountController(OrderAmountService orderAmountService) {
		this.orderAmountService = orderAmountService;
	}
	
	@GetMapping(value = "/orderamounts")
	public ResponseEntity<List<OrderAmountListJson>> getAllOrderAmounts() throws OrderAmountException {
		return ResponseEntity.ok(oaBusiness.getListOrderAmounts());
	}
	
	@GetMapping(value = "/orderamounts/order/{orderId}")
	public ResponseEntity<List<OrderAmountListJson>> getOrderAmountByShopOrderId(@PathVariable("shopOrderId") long shopOrderId) throws OrderAmountException {
		return ResponseEntity.ok(oaBusiness.getOrderAmountByShopOrderId(shopOrderId));
	}
	
	@PostMapping(value = "/orderamounts")
	public ResponseEntity<Void> saveOrderAmount(@RequestBody OrderAmountPayload payload) throws OrderAmountException {
		oaBusiness.saveOrderAmount(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/orderamounts/{id}")
	public ResponseEntity<OrderAmountListJson> updateOrderAmount(@PathVariable("id") long id, @RequestBody OrderAmountPayload payload) throws OrderAmountException {
		Optional<OrderAmount> oaData = orderAmountService.findOptionalById(id);
		if (oaData.isPresent()) {
			oaBusiness.updateOrderAmount(oaData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/orderamounts/{id}")
	public ResponseEntity<HttpStatus> deleteOrderAmount(@PathVariable("id") long id) throws OrderAmountException {
		try {
			oaBusiness.deleteOrderAmount(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

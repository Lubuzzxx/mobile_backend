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

import com.projectapi.projectapi.shop.business.CartBusiness;
import com.projectapi.projectapi.shop.exception.CartException;
import com.projectapi.projectapi.shop.json.CartListJson;
import com.projectapi.projectapi.shop.model.Cart;
import com.projectapi.projectapi.shop.payload.CartPayload;
import com.projectapi.projectapi.shop.service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	CartBusiness cBusiness;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	//find
	@GetMapping(value = "/carts")
	public ResponseEntity<List<CartListJson>> getAllCarts() throws CartException {
		return ResponseEntity.ok(cBusiness.getListCarts());
	}
	
	//id
	@GetMapping(value = "/carts/cus/{cusId}")
	public ResponseEntity<List<CartListJson>> getCartByCustomerId(@PathVariable("cusId") long cusId) throws CartException {
		return ResponseEntity.ok(cBusiness.getCartByCusId(cusId));
	}
	
//	{
//    "product" : {
//        "id" : 2
//    },
//    "customer" : {
//        "id" : 1
//    },
//    "amount" : 2
//}
	//insert 
	@PostMapping(value = "/carts")
	public ResponseEntity<Void> saveAndCheckDuplicate(@RequestBody CartPayload payload) throws CartException {
		cBusiness.saveAndCheckDuplicate(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
//	@PostMapping(value = "/carts")
//	public ResponseEntity<Void> saveCart(@RequestBody CartPayload payload) throws CartException {
//		cBusiness.saveCart(payload);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
	
	//edit
	//http://localhost:8080/api/carts/11
//	{
//	    "product" : {
//	        "id" : 3
//	    },
//	    "customer" : {
//	        "id" : 1
//	    },
//	    "amount" : 4
//	}
	@PutMapping(value = "/carts/{id}")
	public ResponseEntity<CartListJson> updateCart(@PathVariable("id") long id, @RequestBody CartPayload payload) throws CartException {
		Optional<Cart> enrolmentData = cartService.findOptionalById(id);
		if (enrolmentData.isPresent()) {
			cBusiness.updateCart(enrolmentData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete
//	@DeleteMapping(value = "/carts/{id}")
//	public ResponseEntity<HttpStatus> deleteCart(@PathVariable("id") long id) throws CartException {
//		try {
//			cBusiness.deleteCart(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	//delete ใช้ด้วยไม่งั้นกดเพิ่มใน shop order ใน cart มันจะยังอยู่
	@DeleteMapping(value = "/carts/cus/{customerId}")
	public ResponseEntity<HttpStatus> deleteCartByCustomerId(@PathVariable("customerId") long customerId) throws CartException {
		try {
			cBusiness.deleteCartByCustomerId(customerId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	
}

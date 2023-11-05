package com.projectapi.projectapi.shop.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.json.CartListJson;
import com.projectapi.projectapi.shop.model.Cart;
import com.projectapi.projectapi.shop.model.Customer;
import com.projectapi.projectapi.shop.model.Product;
import com.projectapi.projectapi.shop.payload.CartPayload;
import com.projectapi.projectapi.shop.repository.CartRepository;
import com.projectapi.projectapi.shop.service.CartService;

@Service
public class CartBusiness {

	@Autowired
	CartService cartService;
	
	@Autowired
	CartRepository cartRepository;
	
	public List<CartListJson> getListCarts() {
		return CartListJson.packJsons(cartService.findAllCarts());
	}
	
	public List<CartListJson> getCartByCusId(long id) {
		return CartListJson.packJsons(cartService.findByCustomerId(id));
	}
	
	public void saveCart(CartPayload cpl) {
		Cart cart = new Cart(
				cpl.getProduct(),
				cpl.getCustomer(),
				cpl.getAmount());
		cartService.save(cart);
	}
	
	public void updateCart(long id, CartPayload payload) {
		Cart cData = cartService.findById(id);
		cData.setProduct(payload.getProduct());
		cData.setCustomer(payload.getCustomer());
		cData.setAmount(payload.getAmount());
		cartService.save(cData);
	}
	
	public void deleteCart(long id) {
		cartService.deleteById(id);
	}
	
	public void deleteCartByCustomerId(long customerId) {
		List<Cart> cartCustomers = cartService.findByCustomerId(customerId);
		for (Cart cartCustomer : cartCustomers) {
//			cartService.deleteCartsByCustomerId(cartCustomer.getCustomer().getId());
			cartService.deleteById(cartCustomer.getId());
		}

	}
	
	public void saveAndCheckDuplicate(CartPayload cpl) {
		Cart cart = new Cart(
				cpl.getProduct(),
				cpl.getCustomer(),
				cpl.getAmount());
        Cart check = cartRepository.findByCustomerAndProduct(cart.getCustomer(), cart.getProduct());
        if(check == null) {
        	cartService.save(cart);
        }else {
        	if(cpl.getAmount()>=1) {
        		updateCart(check.getId(),cpl);
        	}
        	
        }
    }
	
}

package com.projectapi.projectapi.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.model.ShopOrder;
import com.projectapi.projectapi.shop.repository.ShopOrderRepository;

@Service
public class ShopOrderService implements IShopOrder{

	@Autowired
	ShopOrderRepository shopOrderRepository;
	
	public ShopOrderService(ShopOrderRepository shopOrderRepository) {
		this.shopOrderRepository = shopOrderRepository;
	}

	@Override
	public List<ShopOrder> findAllOrders() {
		// TODO Auto-generated method stub
		return shopOrderRepository.findAll();
	}

	@Override
	public ShopOrder findById(long id) {
		// TODO Auto-generated method stub
		return shopOrderRepository.findById(id);
	}

	@Override
	public List<ShopOrder> findByCustomerId(long id) {
		// TODO Auto-generated method stub
		return shopOrderRepository.findByCustomerId(id);
	}

	@Override
	public List<ShopOrder> findByStatus(String status) {
		// TODO Auto-generated method stub
		return shopOrderRepository.findByStatus(status);
	}

	@Override
	public ShopOrder save(ShopOrder so) {
		// TODO Auto-generated method stub
		return shopOrderRepository.save(so);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		shopOrderRepository.deleteById(id);
	}
	
	public Optional<ShopOrder> findOptionalById(long id){
		return shopOrderRepository.findOptionalById(id);
	}
	
//	 public Long createShopOrder() {
//	        ShopOrder shopOrder = new ShopOrder();
//	        shopOrderRepository.save(shopOrder);
//	        return shopOrder.getId();
//	    }
	
	
}

package com.projectapi.projectapi.shop.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.json.CustomerListJson;
import com.projectapi.projectapi.shop.payload.CustomerPayload;
import com.projectapi.projectapi.shop.service.CustomerService;
import com.projectapi.projectapi.shop.model.Customer;

@Service
public class CustomerBusiness {

	@Autowired
	CustomerService customerService;
	
	public List<CustomerListJson> getListCustomer(){
		return CustomerListJson.packJsons(customerService.getAllCustomers());
	}
	
	public CustomerListJson getCustomerId(long id) {
		return CustomerListJson.packJson(customerService.findById(id));
	}
	
	public CustomerListJson getCustomerByEmail(String email) {
		return CustomerListJson.packJson(customerService.findByEmail(email));
	}
	public void saveCustomer(CustomerPayload cpl) {
		Customer cus = new Customer(
				cpl.getEmail(),
				cpl.getPassword(),
				cpl.getName(),
				cpl.getAddress(),
				cpl.getPhoneNumber());
		customerService.save(cus);
	}
	
	public void updateCustomer(long id, CustomerPayload payload) {
		Customer cusData = customerService.findById(id);
		cusData.setEmail(payload.getEmail());
		cusData.setPassword(payload.getPassword());
		cusData.setName(payload.getName());
		cusData.setAddress(payload.getAddress());
		cusData.setPhoneNumber(payload.getPhoneNumber());
		customerService.save(cusData);
	}
	
	public void deleteCustomer(long id) {
		customerService.deleteById(id);
	}
	
}

package com.projectapi.projectapi.shop.service;

import java.util.List;
import com.projectapi.projectapi.shop.model.Customer;

public interface ICustomer {
	List<Customer> getAllCustomers();
	Customer findById(long id);
	Customer findByEmail(String email);
	Customer save(Customer cus);
	boolean verifyUser(String email, String password);
	void deleteById(long id);
}

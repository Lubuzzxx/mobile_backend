package com.projectapi.projectapi.shop.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.model.Customer;
import com.projectapi.projectapi.shop.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomer{

	CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
	}

	@Override
	public Customer findByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email);
	}

	@Override
	public Customer save(Customer cus) {
		// TODO Auto-generated method stub
		return customerRepository.save(cus);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}
	
	public Optional<Customer> findOptionalById(long id){
		return customerRepository.findOpionalById(id);
	}
	
	public boolean verifyUser(String email, String password) {
        Customer customer = customerRepository.findByEmailAndPassword(email, password);
        return customer != null;
    }
	
}

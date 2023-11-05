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

import com.projectapi.projectapi.shop.business.CustomerBusiness;
import com.projectapi.projectapi.shop.json.CustomerListJson;
import com.projectapi.projectapi.shop.model.Customer;
import com.projectapi.projectapi.shop.payload.CustomerPayload;
import com.projectapi.projectapi.shop.service.CustomerService;
import com.projectapi.projectapi.exception.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerService customerservice;
	
	@Autowired
	CustomerBusiness cBusiness;
	
	public CustomerController(CustomerService customerservice) {
		this.customerservice = customerservice;
	}
	
	
//	{
//	    "email" : "blade@qq.cn",
//	    "password" : "admin",
//	    "name" : "Blade",
//	    "address" : "88 St.lor buu, Manchester, 5700",
//	    "phoneNumber" : "+5514878426"
//	}
	@PostMapping(value = "/customers")
	public ResponseEntity<Void> saveCustomer(@RequestBody CustomerPayload payload) throws BaseException{
		cBusiness.saveCustomer(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//all id
	@GetMapping(value="/customers")
	public ResponseEntity<List<CustomerListJson>> getAllCustomers() throws BaseException{
		return ResponseEntity.ok(cBusiness.getListCustomer());
	}
	
	//find from id
	@GetMapping(value="/customers/{id}")
	public ResponseEntity<CustomerListJson> getCustomerById(@PathVariable("id")  long id) throws BaseException{
		return ResponseEntity.ok(cBusiness.getCustomerId(id));
	}
	
	//email
	@GetMapping(value="/customers/email/{email}")
	public ResponseEntity<CustomerListJson> getCustomerByEmail(@PathVariable("email")  String email) throws BaseException{
		return ResponseEntity.ok(cBusiness.getCustomerByEmail(email));
	}
	
	//update
	@PutMapping("/customers/{id}")
	public ResponseEntity<CustomerListJson> updateCustomer(@PathVariable("id") long id,
			@RequestBody CustomerPayload payload){
		Optional<Customer> cData = customerservice.findOptionalById(id);
		if(cData.isPresent()) {
			cBusiness.updateCustomer(cData.get().getId(),payload);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id){
		try {
			cBusiness.deleteCustomer(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//verify login
	@PostMapping("/customers/login")
    public String login(@RequestBody Customer cus) {
        String email = cus.getEmail();
        String password = cus.getPassword();

        if (customerservice.verifyUser(email, password)) {
            return "Login successful!";
        } else {
            return "Invalid email or password. Please try again.";
        }
    }

}

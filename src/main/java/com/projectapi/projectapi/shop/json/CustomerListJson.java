package com.projectapi.projectapi.shop.json;

import java.util.ArrayList;
import java.util.List;

import com.projectapi.projectapi.shop.model.Customer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CustomerListJson {
	private long id;
	private String email;
	private String password;
	private String name;
	private String address;
	private String phoneNumber;
	
	public static CustomerListJson packJson(Customer cus) {
		CustomerListJson clj = new CustomerListJson();
		clj.setId(cus.getId());
		clj.setEmail(cus.getEmail());
		clj.setName(cus.getName());
		clj.setPassword(cus.getPassword());
		clj.setAddress(cus.getAddress());
		clj.setPhoneNumber(cus.getPhoneNumber());
		return clj;
		
	}
	
	public static List<CustomerListJson> packJsons(List<Customer> customers){
		List<CustomerListJson> clj = new ArrayList<CustomerListJson>();
		for(Customer customer:customers) {
			clj.add(packJson(customer));
		}
		return clj;
	}
	
}

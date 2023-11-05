package com.projectapi.projectapi.shop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name="Customer")
@Table(
		name = "customer",
		uniqueConstraints = {
				@UniqueConstraint(name="customer_email.unique", columnNames = "email")
		}
	)
public class Customer {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;
	
	public Customer() {
		;
	}
	
	public Customer(String email,String password,String name,String address,String phoneNumber) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
}

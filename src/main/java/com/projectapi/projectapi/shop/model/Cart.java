package com.projectapi.projectapi.shop.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name="Cart")
@Table(
		name = "cart"
	)
public class Cart {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Customer customer;
	
	@Column(name = "amount", nullable = false)
	private int amount;

	public Cart() {
		;
	}
	
	public Cart(Product product,Customer customer,int amount) {
		super();
		this.customer = customer;
		this.product = product;
		this.amount = amount;
	}
}

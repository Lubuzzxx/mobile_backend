package com.projectapi.projectapi.shop.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
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
@Entity(name="ShopOrder")
@Table(
		name = "shopOrder",
		uniqueConstraints = {
				
		}
	)
public class ShopOrder {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@CreationTimestamp
	@Column(name = "create_at", nullable = false,
	updatable = false, insertable = false ,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime orderAt;
	
	@Column(name = "total_price", nullable = false)
	private int totalPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Customer customer;
	
	@Column(name = "deliver", nullable = false)
	private String deliver;
	
	@Column(name = "payMethod", nullable = false)
	private String payMethod;
	
	@Column(name = "receipt", nullable = false)
	private String receipt;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	public ShopOrder() {
		;
	}
	
	public ShopOrder(int total_price,Customer customer,String deliver,String payMethod,String receipt,String status) {
		super();
		this.totalPrice = total_price;
		this.customer = customer;
		this.deliver = deliver;
		this.payMethod = payMethod;
		this.receipt = receipt;
		this.status = status;
	}

}

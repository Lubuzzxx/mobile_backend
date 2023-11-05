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
@Entity(name="OrderAmount")
@Table(
		name = "orderAmount"
	)
public class OrderAmount {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shopOrder_id", nullable = true)
	@Fetch(FetchMode.JOIN)
	private ShopOrder shopOrder;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Product product;
	
	@Column(name = "amount", nullable = false)
	private int amount;

	public OrderAmount() {
		;
	}
	
	public OrderAmount(Product product,ShopOrder shopOrder,int amount) {
		super();
		this.shopOrder = shopOrder;
		this.product = product;
		this.amount = amount;
	}
}

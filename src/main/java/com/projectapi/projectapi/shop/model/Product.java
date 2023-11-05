package com.projectapi.projectapi.shop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name="Product")
@Table(
		name = "product",
		uniqueConstraints = {
				
		}
	)
public class Product {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "picture", nullable = false)
	private String picture;
	
	@Column(name = "price", nullable = false)
	private int price;
	
	@Column(name = "size", nullable = false)
	private String size;
	
	@Column(name = "color", nullable = false)
	private String color;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "amount", nullable = false)
	private int amount;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "rating", nullable = false)
	private String rating;
	
	public Product() {
		;
	}
	
	public Product(String name, String picture,int price,String size,String color,String description,int amount,String type,String rating) {
		super();
		this.name = name;
		this.picture = picture;
		this.price = price;
		this.size = size;
		this.color = color;
		this.description = description;
		this.amount = amount;
		this.type = type;
		this.rating =rating;
	}
	
}

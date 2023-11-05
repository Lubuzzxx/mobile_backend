package com.projectapi.projectapi.shop.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductPayload {
	private String name;
	private String picture;
	private int price;
	private String size;
	private String color;
	private String description;
	private int amount;
	private String type;
	private String rating;
}

package com.projectapi.projectapi.shop.json;

import java.util.ArrayList;
import java.util.List;

import com.projectapi.projectapi.shop.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductListJson {
	private long id;
	private String name;
	private String picture;
	private int price;
	private String size;
	private String color;
	private String description;
	private int amount;
	private String type;
	private String rating;
	
	public static ProductListJson packJson(Product product) {
		ProductListJson plj = new ProductListJson();
		plj.setId(product.getId());
		plj.setName(product.getName());
		plj.setPicture(product.getPicture());
		plj.setPrice(product.getPrice());
		plj.setSize(product.getSize());
		plj.setColor(product.getColor());
		plj.setDescription(product.getDescription());
		plj.setAmount(product.getAmount());
		plj.setType(product.getType());
		plj.setRating(product.getRating());
		
		return plj;
	}
	public static List<ProductListJson> packJsons(List<Product> products){
		List<ProductListJson> productListJson = new ArrayList<ProductListJson>();
		for(Product product : products) {
			productListJson.add(packJson(product));
		}
		return productListJson;
	}
}

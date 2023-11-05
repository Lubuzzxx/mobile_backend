package com.projectapi.projectapi.shop.json;

import com.projectapi.projectapi.shop.model.Favorite;

import java.util.ArrayList;
import java.util.List;

import com.projectapi.projectapi.shop.model.Customer;
import com.projectapi.projectapi.shop.model.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FavoriteListJson {
	private long id;
	private Product product;
	private Customer customer;
	
	public static FavoriteListJson packJson(Favorite fav) {
		FavoriteListJson flj = new FavoriteListJson();
		flj.setId(fav.getId());
		flj.setProduct(fav.getProduct());
		flj.setCustomer(fav.getCustomer());
		return flj;
	}
	
	public static List<FavoriteListJson> packJsons(List<Favorite> favs){
		List<FavoriteListJson> flj = new ArrayList<FavoriteListJson>();
		for(Favorite fav : favs) {
			flj.add(packJson(fav));
		}
		return flj;
	}

}

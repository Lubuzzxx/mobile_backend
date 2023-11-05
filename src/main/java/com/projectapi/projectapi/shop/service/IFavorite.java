package com.projectapi.projectapi.shop.service;

import java.util.List;

import com.projectapi.projectapi.shop.model.Favorite;

public interface IFavorite {
	List<Favorite> findAllFavorites();
	Favorite findById(long id);
	List<Favorite> findByCustomerId(long customerId);
	Favorite save(Favorite fav);
	void deleteById(long id);
	void deleteFavoritesByCustomerId(Long customerId);
}

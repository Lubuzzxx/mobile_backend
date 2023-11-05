package com.projectapi.projectapi.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.model.Favorite;
import com.projectapi.projectapi.shop.repository.FavoriteRepository;

@Service
public class FavoriteService implements IFavorite {
	
	@Autowired
	FavoriteRepository favoriteRepository;
	
	public FavoriteService(FavoriteRepository favoriteRepository) {
		this.favoriteRepository = favoriteRepository;
	}

	@Override
	public List<Favorite> findAllFavorites() {
		// TODO Auto-generated method stub
		return favoriteRepository.findAll();
	}

	@Override
	public Favorite findById(long id) {
		// TODO Auto-generated method stub
		return favoriteRepository.findById(id);
	}

	@Override
	public List<Favorite> findByCustomerId(long customerId) {
		// TODO Auto-generated method stub
		return favoriteRepository.findByCustomerId(customerId);
	}

	@Override
	public Favorite save(Favorite fav) {
		// TODO Auto-generated method stub
		return favoriteRepository.save(fav);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		favoriteRepository.deleteById(id);
	}

	@Override
	public void deleteFavoritesByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		favoriteRepository.deleteByCustomerId(customerId);
	}
	
	public Optional<Favorite> findOptionalById(long id) {
		return favoriteRepository.findOptionalById(id);
	}

}

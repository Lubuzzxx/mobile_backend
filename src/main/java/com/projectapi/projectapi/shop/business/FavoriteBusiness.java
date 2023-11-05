package com.projectapi.projectapi.shop.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.json.FavoriteListJson;
import com.projectapi.projectapi.shop.model.Favorite;
import com.projectapi.projectapi.shop.payload.FavoritePayload;
import com.projectapi.projectapi.shop.repository.FavoriteRepository;
import com.projectapi.projectapi.shop.service.FavoriteService;

@Service
public class FavoriteBusiness {

	@Autowired
	FavoriteService favoriteService;
	
	@Autowired
	FavoriteRepository favoriteRepository;
	
	public List<FavoriteListJson> getListFavorites() {
		return FavoriteListJson.packJsons(favoriteService.findAllFavorites());
	}
	
	public List<FavoriteListJson> getFavoriteByCusId(long id) {
		return FavoriteListJson.packJsons(favoriteService.findByCustomerId(id));
	}
	
	public void saveFavorite(FavoritePayload fpl) {
		Favorite cart = new Favorite(
				fpl.getProduct(),
				fpl.getCustomer());
		favoriteService.save(cart);
	}
	
	public void updateFavorite(long id, FavoritePayload payload) {
		Favorite fData = favoriteService.findById(id);
		fData.setProduct(payload.getProduct());
		fData.setCustomer(payload.getCustomer());
		favoriteService.save(fData);
	}
	
	public void deleteFavorite(long id) {
		favoriteService.deleteById(id);
	}
	
	public void deleteCartByFavoriteId(long customerId) {
		List<Favorite> favCustomers = favoriteService.findByCustomerId(customerId);
		for (Favorite favCustomer : favCustomers) {
			favoriteService.deleteById(favCustomer.getId());
		}

	}
	
	public void saveAndCheckDuplicate(FavoritePayload fpl) {
		Favorite fav = new Favorite(
				fpl.getProduct(),
				fpl.getCustomer());
        Favorite check = favoriteRepository.findByCustomerAndProduct(fav.getCustomer(), fav.getProduct());
        if(check == null) {
        	favoriteService.save(fav);
        }
    }
	
}

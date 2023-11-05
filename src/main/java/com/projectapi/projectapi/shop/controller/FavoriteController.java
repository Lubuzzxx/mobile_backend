package com.projectapi.projectapi.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectapi.projectapi.shop.business.FavoriteBusiness;
import com.projectapi.projectapi.shop.exception.FavoriteException;
import com.projectapi.projectapi.shop.json.FavoriteListJson;
import com.projectapi.projectapi.shop.model.Favorite;
import com.projectapi.projectapi.shop.payload.FavoritePayload;
import com.projectapi.projectapi.shop.service.FavoriteService;

@RestController
@RequestMapping("/api")
public class FavoriteController {

	@Autowired
	FavoriteService favoriteService;
	
	@Autowired
	FavoriteBusiness fBusiness;
	
	public FavoriteController(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}
	
	//
	@GetMapping(value = "/favs")
	public ResponseEntity<List<FavoriteListJson>> getAllFavorites() throws FavoriteException {
		return ResponseEntity.ok(fBusiness.getListFavorites());
	}
	
	//
	@GetMapping(value = "/favs/cus/{cusId}")
	public ResponseEntity<List<FavoriteListJson>> getFavoriteByCustomerId(@PathVariable("cusId") long cusId) throws FavoriteException {
		return ResponseEntity.ok(fBusiness.getFavoriteByCusId(cusId));
	}
	
	//
//	{
//	    "customer" : {
//	        "id" : 1
//	    },
//	    "product" : {
//	        "id" : 4
//	    }
//	}
	@PostMapping(value = "/favs")
	public ResponseEntity<Void> saveAndCheckDuplicate(@RequestBody FavoritePayload payload) throws FavoriteException {
		fBusiness.saveAndCheckDuplicate(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//
	@PutMapping(value = "/favs/{id}")
	public ResponseEntity<FavoriteListJson> updateFavorite(@PathVariable("id") long id, @RequestBody FavoritePayload payload) throws FavoriteException {
		Optional<Favorite> favData = favoriteService.findOptionalById(id);
		if (favData.isPresent()) {
			fBusiness.updateFavorite(favData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//
	@DeleteMapping(value = "/favs/{id}")
	public ResponseEntity<HttpStatus> deleteCart(@PathVariable("id") long id) throws FavoriteException {
		try {
			fBusiness.deleteFavorite(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

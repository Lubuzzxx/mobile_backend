package com.projectapi.projectapi.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.projectapi.projectapi.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FavoriteException extends BaseException{
private static final long serialVersionUID = 1L;
	
	public FavoriteException(String code, HttpStatus status) {
		super("fav." + code, status);
	}
	public static FavoriteException emptyFavorite() {
		return new FavoriteException("findFav.notFound", HttpStatus.BAD_REQUEST);
	}
}

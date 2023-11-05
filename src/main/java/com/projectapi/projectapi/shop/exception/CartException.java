package com.projectapi.projectapi.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.projectapi.projectapi.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CartException  extends BaseException {
	private static final long serialVersionUID = 1L;
	
	public CartException(String code, HttpStatus status) {
		super("cart." + code, status);
	}
	public static CartException emptyCart() {
		return new CartException("findCart.notFound", HttpStatus.BAD_REQUEST);
	}
}


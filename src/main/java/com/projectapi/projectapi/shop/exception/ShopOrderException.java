package com.projectapi.projectapi.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.projectapi.projectapi.exception.BaseException;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ShopOrderException extends BaseException {
	private static final long serialVersionUID = 1L;
	
	public ShopOrderException(String code, HttpStatus status) {
		super("shoporder." + code, status);
	}
	public static ShopOrderException emptyShopOrder() {
		return new ShopOrderException("findShopOrder.notFound", HttpStatus.BAD_REQUEST);
	}
}

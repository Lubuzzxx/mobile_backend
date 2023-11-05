package com.projectapi.projectapi.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.projectapi.projectapi.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderAmountException extends BaseException {
	private static final long serialVersionUID = 1L;
	
	public OrderAmountException(String code, HttpStatus status) {
		super("orderAmount." + code, status);
	}
	public static OrderAmountException emptyOrderAmount() {
		return new OrderAmountException("findOrderAmount.notFound", HttpStatus.BAD_REQUEST);
	}
}

package com.projectapi.projectapi.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.projectapi.projectapi.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductException extends BaseException {
	private static final long serialVersionUID = 1L;
	
	public ProductException(String code, HttpStatus status) {
		super("product." + code, status);
	}
	public static ProductException emptyProduct() {
		return new ProductException("findProduct.notFound", HttpStatus.BAD_REQUEST);
	}
}


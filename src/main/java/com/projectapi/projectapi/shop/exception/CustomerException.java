package com.projectapi.projectapi.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.projectapi.projectapi.exception.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerException extends BaseException {
	private static final long serialVersionUID = 1L;
	
	public CustomerException(String code, HttpStatus status) {
		super("customer." + code, status);
	}
	public static CustomerException emptyCustomer() {
		return new CustomerException("findCustomer.notFound", HttpStatus.BAD_REQUEST);
	}
}

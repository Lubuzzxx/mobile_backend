package com.projectapi.projectapi.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.projectapi.projectapi.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AdminException extends BaseException {
	private static final long serialVersionUID = 1L;
	
	public AdminException(String code, HttpStatus status) {
		super("admin." + code, status);
	}
	public static AdminException emptyAdmin() {
		return new AdminException("findAdmin.notFound", HttpStatus.BAD_REQUEST);
	}
}

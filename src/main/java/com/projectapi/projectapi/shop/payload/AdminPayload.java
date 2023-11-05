package com.projectapi.projectapi.shop.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminPayload {
	private String email;
	private String password;
	private String name;
}

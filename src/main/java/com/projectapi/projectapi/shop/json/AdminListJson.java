package com.projectapi.projectapi.shop.json;

import java.util.ArrayList;
import java.util.List;

import com.projectapi.projectapi.shop.model.Admin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AdminListJson {
	private long id;
	private String email;
	private String password;
	private String name;
	
	public static AdminListJson packJson(Admin admin) {
		AdminListJson alj = new AdminListJson();
		alj.setId(admin.getId());
		alj.setEmail(admin.getEmail());
		alj.setPassword(admin.getPassword());
		alj.setName(admin.getName());
		return alj;
	}

	public static List<AdminListJson> packJsons(List<Admin> admins){
		List<AdminListJson> adminListJson = new ArrayList<AdminListJson>();
		for(Admin admin : admins) {
			adminListJson.add(packJson(admin));
		}
		return adminListJson;
	}
	
}

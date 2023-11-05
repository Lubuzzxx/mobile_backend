package com.projectapi.projectapi.shop.service;

import java.util.List;
import com.projectapi.projectapi.shop.model.Admin;

public interface IAdmin {
	List<Admin> getAllAdmins();
	Admin findById(long id);
	Admin findByEmail(String email);
	Admin save(Admin am);
	void deleteById(long id);
}

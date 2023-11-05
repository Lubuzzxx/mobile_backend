package com.projectapi.projectapi.shop.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.json.AdminListJson;
import com.projectapi.projectapi.shop.model.Admin;
import com.projectapi.projectapi.shop.payload.AdminPayload;
import com.projectapi.projectapi.shop.service.AdminService;

@Service
public class AdminBusiness {
	
	@Autowired
	AdminService adminService;
	
	public List<AdminListJson> getListAdmin(){
		return AdminListJson.packJsons(adminService.getAllAdmins());
	}
	
	public AdminListJson getAdminId(long id) {
		return AdminListJson.packJson(adminService.findById(id));
	}
	
	public AdminListJson getAdminByEmail(String email) {
		return AdminListJson.packJson(adminService.findByEmail(email));
	}
	
	public void saveAdmin(AdminPayload amp) {
		Admin admin = new Admin(
				amp.getEmail(),
				amp.getPassword(),
				amp.getName());
		adminService.save(admin);
	}

	public void updateAdmin(long id, AdminPayload payload) {
		Admin adminData = adminService.findById(id);
		adminData.setEmail(payload.getEmail());
		adminData.setPassword(payload.getPassword());
		adminData.setName(payload.getName());
		adminService.save(adminData);
	}
	
	public void deleteAdmin(long id) {
		adminService.deleteById(id);
	}
	
}

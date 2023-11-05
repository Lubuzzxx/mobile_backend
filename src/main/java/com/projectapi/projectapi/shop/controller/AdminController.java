package com.projectapi.projectapi.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectapi.projectapi.shop.business.AdminBusiness;
import com.projectapi.projectapi.shop.json.AdminListJson;
import com.projectapi.projectapi.shop.payload.AdminPayload;
import com.projectapi.projectapi.shop.service.AdminService;
import com.projectapi.projectapi.shop.model.Admin;
import com.projectapi.projectapi.exception.*;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@Autowired
	AdminBusiness aBusiness;
	
	public AdminController(AdminService adminservice) {
		this.adminservice = adminservice;
	}
	
	//add admin
//	{
//	    "email" : "admin@cc.cn",
//	    "password" : "admin",
//	    "name" : "one"
//	}
	@PostMapping(value = "/admins")
	public ResponseEntity<Void> saveAdmin(@RequestBody AdminPayload payload) throws BaseException{
		aBusiness.saveAdmin(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//all id
	@GetMapping(value="/admins")
	public ResponseEntity<List<AdminListJson>> getAllAdmins() throws BaseException{
		return ResponseEntity.ok(aBusiness.getListAdmin());
	}
	
	//id
	@GetMapping(value="/admins/{id}")
	public ResponseEntity<AdminListJson> getAdminById(@PathVariable("id")  long id) throws BaseException{
		return ResponseEntity.ok(aBusiness.getAdminId(id));
	}
	
	//find from email
	@GetMapping(value="/admins/email/{email}")
	public ResponseEntity<AdminListJson> getAdminByEmail(@PathVariable("email")  String email) throws BaseException{
		return ResponseEntity.ok(aBusiness.getAdminByEmail(email));
	}
	
	//update info admin
//	{
//	    "email" : "admin@qwerrt.cn",
//	    "password" : "admin",
//	    "name" : "one"
//	}
	@PutMapping("/admins/{id}")
	public ResponseEntity<AdminListJson> updateAdmin(@PathVariable("id") long id,
			@RequestBody AdminPayload payload){
		Optional<Admin> aData = adminservice.findOptionalById(id);
		if(aData.isPresent()) {
			aBusiness.updateAdmin(aData.get().getId(),payload);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete
	@DeleteMapping("/admins/{id}")
	public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("id") long id){
		try {
			aBusiness.deleteAdmin(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	{
//	    "email" : "admin@qwerrt.cn",
//	    "password" : "admin"
//	}
	@PostMapping("/admins/login")
    public String login(@RequestBody Admin admin) {
        String email = admin.getEmail();
        String password = admin.getPassword();

        if (adminservice.verifyUser(email, password)) {
            return "Login successful!";
        } else {
            return "Invalid email or password. Please try again.";
        }
    }
	
}

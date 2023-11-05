package com.projectapi.projectapi.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.model.Admin;
import com.projectapi.projectapi.shop.repository.AdminRepository;

@Service
public class AdminService implements IAdmin{

	AdminRepository adminRepository;
	
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin findById(long id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id);
	}

	@Override
	public Admin findByEmail(String email) {
		// TODO Auto-generated method stub
		return adminRepository.findByEmail(email);
	}

	@Override
	public Admin save(Admin am) {
		// TODO Auto-generated method stub
		return adminRepository.save(am);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(id);
	}
	
	public Optional<Admin> findOptionalById(long id){
		return adminRepository.findOpionalById(id);
	}
	
	public boolean verifyUser(String email, String password) {
        Admin admin = adminRepository.findByEmailAndPassword(email, password);
        return admin != null;
    }
	
}

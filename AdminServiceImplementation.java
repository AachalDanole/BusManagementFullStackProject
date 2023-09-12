package com.BusManagement.BusServiceImplementation;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BusManagement.Bus.Admin;
import com.BusManagement.BusRepository.AdminRepository;

@Service
public class AdminServiceImplementation {

@Autowired
	private AdminRepository adminRepo;
	
	public void addadmin(Admin admin) {
		
		this.adminRepo.save(admin);
		
	}

	public Optional<Admin> getadminByEmail(String email) {
		
		return this.adminRepo.findByadminEmail(email);
		
	}


}
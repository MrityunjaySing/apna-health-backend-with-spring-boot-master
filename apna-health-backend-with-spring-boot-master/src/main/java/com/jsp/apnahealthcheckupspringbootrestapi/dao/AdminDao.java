package com.jsp.apnahealthcheckupspringbootrestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Admin;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.AdminRepository;

@Repository
public class AdminDao {
 
	@Autowired
	private AdminRepository repository;
	
	public Admin saveAdminDao(Admin admin) {
		return repository.save(admin);
	}
	
	public Admin loginAdminDao(String adminEmail) {
		return repository.findByAdminEmail(adminEmail);
	}
	
	public List<Admin>  getAllAdminDataDao(){
		
		return repository.findAll();
	}
}

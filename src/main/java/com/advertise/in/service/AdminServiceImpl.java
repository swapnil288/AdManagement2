package com.advertise.in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advertise.in.exception.AdminNotFoundException;
import com.advertise.in.model.Admin;
import com.advertise.in.repository.AdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired(required=true)
	private AdminRepository repository;
	
	
	/**
	 * This method is used to get admin details
	 * it calls findById() method of adminRepository
	 * @param email
	 * @param password
	 * @return String
	 */
	@Override
	public String getAdmin(String email, String password) {
		// TODO Auto-generated method stub
		Admin admin;
		String s="";
		
		
		if(repository.findById(email).isPresent()) {
			
			admin=repository.findById(email).get();
			
			if(admin.getPassword().equals(password))s="Logged in successfully";
			
			else
				
				s="invalid password";
		}else
				throw new AdminNotFoundException(email);
		       return s;
    }
		
		
	/**
	 * Used to update admin Details
	 * @param email
	 * @param admin
	 * @return Admin
	 */
	@Override
	public Admin updateAdminPassword(String email, Admin admin1) {
		// TODO Auto-generated method stub

		Admin admin=null;
		
		if(repository.findById(email).isPresent()) 
		{
			admin=(Admin)repository.findById(email).get();
			admin.setPassword(admin1.getPassword());
			
		}
		
		else
			
			throw new AdminNotFoundException(email);
		    return repository.save(admin);
		
	}

}

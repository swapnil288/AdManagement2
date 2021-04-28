package com.advertise.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advertise.in.exception.AdminNotFoundException;
import com.advertise.in.model.Admin;
import com.advertise.in.service.IAdminService;



@CrossOrigin
@RestController
@RequestMapping(value="/login")
public class AdminController {

	@Autowired(required=true)
	public IAdminService adminservice;
	
	
	/**
	 * This method is used to fetch admin details
	 * from database by passing control to  service by calling getAdmin()
	 * @param email
	 * @param password
	 * @return ResponseEntity<String>
	 * @throws AdminNotFoundException
	 */
	@GetMapping(value="/admin/{email}/{password}")
	public ResponseEntity<String>getAdmin(@PathVariable String email,@PathVariable String password)throws AdminNotFoundException{
		
		String message=adminservice.getAdmin(email,password);
		
		return new ResponseEntity<>(message,HttpStatus.OK);
	
	}	
	
	/**
	 * This method is used to update admin details
	 * from database by passing control to  service by calling updateAdminPassword()
	 * @param email
	 * @param newadmin
	 * @return ResponseEntity<Admin>
	 */
	@PatchMapping(value="/adminresetpassword/{email}")
	public ResponseEntity<Admin>updateAdminPassword(@PathVariable String email,
			@RequestBody Admin newadmin)
	{
		return new ResponseEntity<>(adminservice.updateAdminPassword(email, newadmin),HttpStatus.OK);
		
	}
	
}

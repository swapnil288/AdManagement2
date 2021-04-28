package com.advertise.in.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advertise.in.exception.ResourceNotFoundException;
import com.advertise.in.model.RegisterUserEntity;
import com.advertise.in.service.RegisterUserServiceImpl;



@CrossOrigin
@RestController
@RequestMapping(value="/news")
public class RegisterUserController {

	public String emailLogin;
	
	@Autowired
	private RegisterUserServiceImpl registerService;
	
	
	/**
	 * This method is used to add/register new user
	 * it calls createRegisterUserEntity() method of registerService
	 * @param registeruser
	 * @return ResponseEntity<String>
	 */
	@PostMapping(value="/user",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addNewUser(@RequestBody RegisterUserEntity registeruser)
	{

		registerService.createRegisterUserEntity(registeruser);
	    return new ResponseEntity<String>(" New user create Successfully ",HttpStatus.OK);

	}
	
	
	/**
	 * Used to get Customer details for login
	 * @param emailId
	 * @param password
	 * @return ResponseEntity<String>
	 */
	@GetMapping(value="/customer/{emailId}/{password}")
	public ResponseEntity<String> getCustomer(@PathVariable String emailId,@PathVariable String password){
		
		emailLogin = registerService.UserLogin(emailId, password);
		System.out.println(emailLogin);
		return new ResponseEntity<>("Login Successful",HttpStatus.OK);
	
	}	
	
	
	/**
	 * This method is used to update user details
	 * calls updateUser() method of registerService
	 * @param updateData
	 * @return ResponseEntity<String>
	 */
	@PatchMapping(value = "/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody Map<String,String> updateData)
	{
		if(emailLogin == null)
		{
			throw new ResourceNotFoundException("Dear Customer Please login first");
		}
		RegisterUserEntity user=registerService.updateUser(updateData);
		return new ResponseEntity<String>("Updated Successfully :)",HttpStatus.OK);
	}
	
}

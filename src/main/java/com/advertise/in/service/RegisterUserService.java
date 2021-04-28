package com.advertise.in.service;

import com.advertise.in.model.RegisterUserEntity;

import javassist.NotFoundException;

public interface RegisterUserService {
	
	/**
	 * Used to create new user
	 * @param registerUser
	 * @return
	 */
	public static  RegisterUserEntity createRegisterUserEntity(RegisterUserEntity registerUser) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * This is used to get user details for login
	 * @param emailId
	 * @param password
	 * @return String
	 */
	 public String UserLogin(String emailId, String password);

}

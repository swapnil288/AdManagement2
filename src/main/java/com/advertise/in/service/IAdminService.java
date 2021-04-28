package com.advertise.in.service;

import com.advertise.in.model.Admin;

public interface IAdminService {
	
	
	/**
	 * used to get admin details
	 * @param email
	 * @param password
	 * @return String
	 */
	public String getAdmin(String email,String password);
	
	/**
	 * used to update admin details
	 * @param email
	 * @param admin
	 * @return Admin
	 */
	public Admin updateAdminPassword(String email,Admin admin);
	
}

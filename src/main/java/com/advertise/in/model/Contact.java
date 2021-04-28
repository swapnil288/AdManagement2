package com.advertise.in.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contact")
public class Contact {

	@Id
	@GeneratedValue
	private int contactId;
	
	private String email;
	
	private String name;
	
	private String phone;
	
	private String message;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(int contactId, String email, String name, String phone, String message) {
		super();
		this.contactId = contactId;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.message = message;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", email=" + email + ", name=" + name + ", phone=" + phone
				+ ", message=" + message + "]";
	}
	
	
}

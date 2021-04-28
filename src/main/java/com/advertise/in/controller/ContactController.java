package com.advertise.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advertise.in.model.Contact;
import com.advertise.in.service.ContactService;

@CrossOrigin
@RestController
@RequestMapping(value="/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	
	/**
	 * This method is used to create contact details
	 * @param details
	 * @return ResponseEntity<String>
	 */
	@PostMapping(value="/user",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addNewUser(@RequestBody Contact details)
	{

		contactService.createContact(details);
	    return new ResponseEntity<String>("created Successfully ",HttpStatus.OK);

	}

}

package com.advertise.in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advertise.in.model.Contact;
import com.advertise.in.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	
	/**
	 * used to save contact details
	 * calls save() method of contactRepo
	 * @param details
	 * @return Contact
	 */
	 public Contact createContact(Contact details) {
         // TODO Auto-generated method stub
	 return contactRepo.save(details);
	 }
}

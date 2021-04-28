package com.advertise.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advertise.in.exception.ResourceNotFoundException;
import com.advertise.in.model.Advertise;
import com.advertise.in.model.Contact;
import com.advertise.in.model.RegisterUserEntity;
import com.advertise.in.repository.AdvertiseRepository;
import com.advertise.in.repository.ContactRepository;
import com.advertise.in.repository.RegisterUserRepo;

@Service
public class AdvertiseService {

	@Autowired
	private AdvertiseRepository advertRepo;
	
	@Autowired
	private RegisterUserRepo userRepo;
	
	@Autowired
	private ContactRepository contactRepo;
	
	/**
	 * This is used to add new advertisement into database
	 * calls save() method of advertRepo
	 * @param advertise
	 * @return Advertise
	 */
	public Advertise addAdvertise(Advertise advertise) {
		return advertRepo.save(advertise);
	}

	
	/**
	 * This method is used to get All advertisement details
	 * it calls findAll() method of advertRepo
	 * @return List<Advertise>
	 */
	public List<Advertise> getAllAdvertisements()
	{
		List<Advertise> product=(List<Advertise>)advertRepo.findAll();
		return product;
	}
	
	
	/**
	 * This method is used to get Ad by Id
	 * calls findById(eid) method of advertRepo
	 * @param eid
	 * @return Optional<Advertise>
	 */
	public Optional<Advertise> getById(Integer eid) {
		
		Optional<Advertise> product=advertRepo.findById(eid);
		return product;
		
	}
	
	/**
	 * This method is used to update advertisement details
	 * @param updateAd
	 * @param eid
	 * @return Advertise
	 */
	public Advertise updateOrSaveAdvertise(Advertise updateAd, Integer eid) {
		return advertRepo.findById(eid).map(advertise -> {
			advertise.setAdTitle(updateAd.getAdTitle());
			advertise.setAdType(updateAd.getAdType());
			advertise.setDescription(updateAd.getDescription());
			advertise.setBookingDate(updateAd.getBookingDate());
			advertise.setExpiryDate(updateAd.getExpiryDate());
			advertise.setAddress(updateAd.getAddress());
			advertise.setPhoneNo(updateAd.getEmail());
			advertise.setCompanyName(updateAd.getCompanyName());
			advertise.setEmail(updateAd.getEmail());
			advertise.setAmount(updateAd.getAmount());

			return advertRepo.save(updateAd);
		}).orElseGet(() -> {
			return advertRepo.save(updateAd);
		});
	}
	
	
	/**
	 * used to delete particular advertisement details
	 * @param eid
	 */
	public void deleteAdvertisementsById(Integer eid) {
		
		advertRepo.findById(eid).
		orElseThrow(()->new ResourceNotFoundException("Resume with ID"+eid+" is not available. Please enter correct ID :("));	
	    advertRepo.deleteById(eid);
	}
	
	
	/**
	 * This method is used to fetch all customers present in database
	 * it calls findAll() method of userRepo
	 * @return List<RegisterUserEntity>
	 */
	public List<RegisterUserEntity> getAllCustomers()
	{
		List<RegisterUserEntity> customer=(List<RegisterUserEntity>)userRepo.findAll();
		return customer;
	}
	
	
	/**
	 * This method is used to get all issues
	 * Calls findAll() method of contactRepo
	 * @return List<Contact>
	 */
	public List<Contact> getIssues()
	{
		List<Contact> details=(List<Contact>)contactRepo.findAll();
		return details;
	}
	
}

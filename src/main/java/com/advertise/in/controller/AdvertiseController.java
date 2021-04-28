package com.advertise.in.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advertise.in.exception.ErrorDetails;
import com.advertise.in.exception.ResourceNotFoundException;
import com.advertise.in.model.Advertise;
import com.advertise.in.model.Contact;
import com.advertise.in.model.RegisterUserEntity;
import com.advertise.in.repository.AdvertiseRepository;
import com.advertise.in.service.AdvertiseService;
import com.advertise.in.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin
@RestController
@RequestMapping(value = "/advertise")
public class AdvertiseController {
	

	@Autowired
	private AdvertiseService advertService;
	
	@Autowired
	private AdvertiseRepository advertiseRepository;
	
	@Autowired
	private ContactService contactService;
	
	
	/**
	 * This is used to add new advertisement
	 * stores new advertisement to database by calling service method addAdvertise.
	 * @param advertise
	 * @return Advertise
	 */
	@ApiOperation(value="Insert new Advertisement", response= Advertise.class)
	@PostMapping(value ="/register")
	public Advertise createAdvertise(@RequestBody Advertise advertise) {
		
			return advertService.addAdvertise(advertise);
	}
	
	
	/**
	 * This is used to update advertisement details
	 * @param advertise
	 * @param eid
	 * @return ResponseEntity<Advertise>
	 */
	@ApiOperation(value = "update Advertisement Details", response = Advertise.class)
	@PutMapping("/{eid}")
	public ResponseEntity<Advertise> updateOrSaveAdvertise(@RequestBody Advertise advertise,
			@PathVariable Integer eid) {
		if (advertiseRepository.findById(advertise.getEid()).isPresent()) {
			Advertise e = advertService.updateOrSaveAdvertise(advertise, eid);
			return new ResponseEntity<Advertise>(e, HttpStatus.OK);
		} else {
			new ResourceNotFoundException("Employee not exist with id :" + eid);
			return new ResponseEntity<Advertise>(advertise, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	/**
	 * This is used to fetch all advertisement present in database.
	 * by calling getAllAdvertisements() method of service class
	 * @return list<Advertise>
	 */
	@ApiOperation(value = "Fetch all advertisements", response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "SUCCESS",response = Advertise.class),
			@ApiResponse(code = 401,message = "UNAUTHORIZED!",response = ErrorDetails.class),
			@ApiResponse(code = 403,message = "FORBIDDEN!",response = ErrorDetails.class),
			@ApiResponse(code = 484,message = "NOT FOUND",response = ErrorDetails.class)
	})
	@GetMapping(value="/viewAdvertisements")
	public ResponseEntity<List<Advertise>> viewProducts()
	{
		List<Advertise> advertisement=advertService.getAllAdvertisements();
		return new ResponseEntity<List<Advertise>>(advertisement,HttpStatus.OK);
	}
	
	
	/**
	 * This is used to fetch particular Ad by Id
	 * Calls service method getById(eid)
	 * @param eid
	 * @return ResponseEntity<Advertise>
	 */
	@ApiOperation(value = "Fetch Advertisement by Id", response = Advertise.class)
	@GetMapping("/viewAdvertisements/{eid}")
	public ResponseEntity<Advertise> getAdvertisementById(@PathVariable Integer eid) {
		
		Advertise product = advertService.getById(eid).orElseThrow(() -> new ResourceNotFoundException("Advertisement not found with the given id"+eid));
		return ResponseEntity.ok(product);
	}
	
	
	/**
	 * This method is used to delete advertise by its Id
	 * it calls deleteAdvertisementById() method of service class
	 * @param eid
	 * @return ResponseEntity<String>
	 */
	@ApiOperation(value = "Delete an Advertisement",response = Advertise.class)
	@DeleteMapping(value="/viewAdvertisements/{eid}")
    public ResponseEntity<String>deleteAdvertisementsById(@PathVariable Integer eid) {

   List<Advertise> advertisement=advertService.getAllAdvertisements();

      advertService.deleteAdvertisementsById(eid);
      return new ResponseEntity<String>("Delete With ID : " + eid + "Deleted", HttpStatus.OK);
      
   }
	
	
	/**
	 * This method is used to fetch all customers from database
	 * it calls getAllCustomers() method of service class
	 * @return List<RegisterUserEnitity>
	 */
	@ApiOperation(value = "Fetch all Customers", response = Iterable.class)
	@GetMapping(value="/viewCustomers")
	public ResponseEntity<List<RegisterUserEntity>> viewCustomers()
	{
		List<RegisterUserEntity> customers=advertService.getAllCustomers();
		return new ResponseEntity<List<RegisterUserEntity>>(customers,HttpStatus.OK);
	}
	
	
	/**
	 * This is used to fetch all issues from database
	 * calls getIssues() method of service class
	 * @return List<Contact>
	 */
	@ApiOperation(value = "Fetch all Issues", response = Iterable.class)
	@GetMapping(value="/viewIssues")
	public ResponseEntity<List<Contact>> viewDetails()
	{
		List<Contact> details=advertService.getIssues();
		return new ResponseEntity<List<Contact>>(details,HttpStatus.OK);
	}
	
	
	
}

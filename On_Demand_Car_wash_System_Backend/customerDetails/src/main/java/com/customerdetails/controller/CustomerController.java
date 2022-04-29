package com.customerdetails.controller;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customerdetails.model.AuthenticationRequest;
import com.customerdetails.model.AuthenticationResponse;
import com.customerdetails.model.Customers;
import com.customerdetails.model.ReviewAndRating;
import com.customerdetails.model.WashPack;
import com.customerdetails.services.CustomerService;
import com.customerdetails.services.MyUserDetailsService;
import com.customerdetails.services.ReviewAndRatingService;
import com.customerdetails.util.JwtUtil;
import com.customerdetails.utilities.GlobalResources;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ReviewAndRatingService reviewAndRatingService;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	// LOGGER
	private Logger logger = GlobalResources.getLogger(CustomerController.class);

	// this is to get All customer details
	@GetMapping("/getall")
	public ResponseEntity<List<Customers>> getAllCustomers() {

		List<Customers> list = customerService.getAllCustomers();
		String methodName = "(Get All Details Of Customer)";
		logger.info(methodName + "Called");

		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));

	}

	@GetMapping("/get-customer/{username}")
	public ResponseEntity<Customers> getCustomerByUsername(@PathVariable("username") String username) {
		try {
			String methodName = "getCustomerByUsername()";
			logger.info(methodName + "Called");
			Customers customer = customerService.findByUsername(username);
			return new ResponseEntity<Customers>(customer, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// This is use to add new Customer
	@PostMapping("/")
	public ResponseEntity<Customers> addCustomer(@RequestBody Customers customers) {
		String methodName = "(Data Added TO Customer)";
		logger.info(methodName + "Called");
		try {
			System.out.println(customers);
			customerService.setCustomers(customers);
			return ResponseEntity.ok(customers);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// this is use to get customer by id
	@GetMapping("/customer-id/{id}")
	public ResponseEntity<Customers> getCustomerById(@PathVariable("id") int id) {
		String methodName = "(Get Data  Of Customer by id)";
		logger.info(methodName + "Called");

		try {
			Customers customer = customerService.getCustomerById(id);
			return ResponseEntity.of(Optional.of(customer));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	// this is use to update customer
	@PutMapping("/update/{id}")
	public ResponseEntity<Customers> updateCustomer(@RequestBody Customers customer, @PathVariable("id") int id) {
		String methodName = "(Update Data  Of Customer)";
		logger.info(methodName + "Called");
		Customers customer1 = null;
		try {
			customer = customerService.updateCustomerById(customer);
			return ResponseEntity.ok().body(customer1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// this is use to delete customer
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Customers> deleteCustomer(@PathVariable("id") int id) {
		String methodName = "(Delete data  Of Customer by id)";
		logger.info(methodName + "Called");
		try {
			Customers customer = customerService.getCustomerById(id);
			customerService.deleteCustomerById(id);
			return ResponseEntity.ok().body(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// For Rating
	// this is use to get rating
	@GetMapping("/ratings")
	public ResponseEntity<List<ReviewAndRating>> getAllRating() {
		try {
			List<ReviewAndRating> list = reviewAndRatingService.giveRatingAndReview();
			return ResponseEntity.of(Optional.of(list));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// this is use to add rating
	@PostMapping("/rating")
	public ResponseEntity<ReviewAndRating> addRating(@RequestBody ReviewAndRating ratings) {
		try {
			reviewAndRatingService.addRating(ratings);
			return ResponseEntity.ok().body(ratings);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// to see all the available wash pack

	@GetMapping("/allpacks")
	public List<WashPack> getpacks() {
		String baseurl = "http://localhost:8701/washPack/";
		WashPack[] washPacks = restTemplate.getForObject(baseurl, WashPack[].class);
		return Arrays.asList(washPacks);
	}
//
//	 @GetMapping("/currentuser")
//	   public Object getCurrentUser(Authentication authentication){
//	return authentication.getPrincipal();
//	}

	   
	// Authenticating Customer
	   
	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
	try {
		System.out.println("This is inside controller and it is working");
	authenticationManager.authenticate(
	new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
	);
	}catch (BadCredentialsException e) {
	throw new Exception("Invalid Username or Password!",e);
	}
	final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
	final String token = jwtUtil.generateToken(userDetails);
	return ResponseEntity.ok(new AuthenticationResponse(token));
	}

	@GetMapping("/current-user")
	public Customers getCurrentUser(Principal principal)
	{
		return ((Customers) this.userDetailsService.loadUserByUsername(principal.getName()));
}

}

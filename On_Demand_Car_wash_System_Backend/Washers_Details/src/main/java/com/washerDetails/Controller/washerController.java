package com.washerDetails.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
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
import org.springframework.web.client.RestTemplate;

import com.washerDetails.model.Leaderboard;
import com.washerDetails.model.ReviewAndRating;
import com.washerDetails.model.Washers;
import com.washerDetails.model.orderDetails;
import com.washerDetails.service.washerService;
import com.washerDetails.utilities.GlobalResources;

@RestController
@RequestMapping("/washer")
@CrossOrigin("*")
public class washerController {
	
	@Autowired
	private washerService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	// LOGGER
		private Logger logger = GlobalResources.getLogger(washerController.class);
	
	//THIS IS USE TO GET ALL DATA FROM Washer
	@GetMapping("/")
    public ResponseEntity<List<Washers>> getAllCustomers() {
		String methodName = "(Get All Details Of Washer)";
		logger.info(methodName + "Called");
        List<Washers> list = service.getAllWashers();

        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));

    }


    
	//This is use to add new Washer
	@PostMapping("/")
	public ResponseEntity<Washers> addCustomer(@RequestBody Washers washer)
	{
		String methodName = "(Washer Added Successfully)";
		logger.info(methodName + "Called");
		try {
			System.out.println(washer);
			service.setWashers(washer);
			return ResponseEntity.ok(washer);
			}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//this is use to get washer by id
		@GetMapping("/{id}")
	    public ResponseEntity<Washers> getWasherById(@PathVariable("id") int id) {
			String methodName = "(successfully got washer by id)";
			logger.info(methodName + "Called");

	        try {
	            Washers washer = service.getWashersById(id);
	            return ResponseEntity.of(Optional.of(washer));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }

	    }
		
		//Update Washer
		@PutMapping("/")
		public ResponseEntity<Washers> update(@RequestBody Washers washer)
		{
			String methodName = "(update washer successfully)";
			logger.info(methodName + "Called");
			return ResponseEntity.ok(this.service.updateWasherById(washer));
		}
		
		// To delete Washer
		 @DeleteMapping("/{id}")
		    public void deleteById(@PathVariable("id") int id) {
		        this.service.deleteById(id);
		    }
		
	
		//To get all Washer By Rest Template
	    @GetMapping("/getLeaderboard")
	    public List<Leaderboard> getLeaderboarad()
	    {
	    	String methodName = "(getting data from leaderboard via rest template)";
			logger.info(methodName + "Called");
	 	   String baseurl="http://localhost:8701/washPack/get-leaderboard";
	 	  Leaderboard[] leaderboard=restTemplate.getForObject(baseurl, Leaderboard[].class);
	 	   return Arrays.asList(leaderboard);   
	 	   }

	    
	    //to see all the available orders
		@GetMapping("/allOrders")
		public List<orderDetails> getOrders() {
			String methodName = "(getting data from allOrders via rest template)";
			logger.info(methodName + "Called");
			String baseurl = "http://localhost:8707/order/getall";
			orderDetails[] orders = restTemplate.getForObject(baseurl, orderDetails[].class);
			return Arrays.asList(orders);
		}
		
		 //To get rating
	    @GetMapping("/allrating")
		public List<ReviewAndRating> getRating() {
	    	String methodName = "(getting data from leaderboard via rest template)";
	    	logger.info(methodName + "Called");
			String baseurl = "http://localhost:8700/customers/ratings";
			ReviewAndRating[] review = restTemplate.getForObject(baseurl, ReviewAndRating[].class);
			return Arrays.asList(review);
		}
	   
}

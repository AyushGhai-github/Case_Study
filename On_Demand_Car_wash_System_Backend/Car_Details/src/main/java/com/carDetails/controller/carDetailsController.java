package com.carDetails.controller;

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

import com.carDetails.Service.ReviewAndRatingService;
import com.carDetails.Service.leaderBoardService;
import com.carDetails.Service.washPackService;
import com.carDetails.model.Customers;
import com.carDetails.model.Leaderboard;
import com.carDetails.model.ReviewAndRating;
import com.carDetails.model.WashPack;
import com.carDetails.model.Washers;
import com.carDetails.model.orderDetails;
import com.carDetails.utilities.GlobalResources;






@RestController
@RequestMapping("/washPack")
@CrossOrigin("*")
public class carDetailsController {
	@Autowired
	private washPackService WashPackService;
	
	@Autowired
	private ReviewAndRatingService reviewAndRatingService;
	
	@Autowired
	private leaderBoardService  leaderboardService ;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//LOGGER
	private Logger logger = GlobalResources.getLogger(carDetailsController.class);
	
	//TO GET ALL WASHPACK
	@GetMapping("/")
    public ResponseEntity<List<WashPack>> getAllCustomers() {
        List<WashPack> list = WashPackService.getAllWashPack();
        String methodName = "(GetWashPack)";
		logger.info(methodName + "Called");

        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));

    }
	//TO GET WASHPACK BY NAME
	@GetMapping("/{name}")
    public ResponseEntity<WashPack> findByName(@PathVariable("name") String name) {

        try {
        	String methodName = "(GetWashPackByName)";
			logger.info(methodName + "Called");
			System.out.println(name);
            WashPack washpack =WashPackService.findByName(name);
            return ResponseEntity.of(Optional.of(washpack));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
	//TO ADD NEW WASHPACK
	
	@PostMapping("/")
	public ResponseEntity<WashPack> addNewWashPack(@RequestBody WashPack pack)
	{
		try {
			String methodName = "(addWashPack)";
			logger.info(methodName + "Called");
			
			System.out.println(pack);
			WashPackService.addNewWashPack(pack);
			return ResponseEntity.ok(pack);
			}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	//TO UPDAT WASHPACK
	
	 @PutMapping("/{name}")
	    public ResponseEntity<WashPack> updateWashPack(@RequestBody WashPack pack, @PathVariable("name") String name) {
	        WashPack pack1 = null;
	        try {
	        	String methodName = "(updateWashPackByName)";
				logger.info(methodName + "Called");
				System.out.println(name);
	            pack = WashPackService.updateWashPackByName(pack);
	            return ResponseEntity.ok().body(pack1);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	// To delete WashPack
	 @DeleteMapping("/{id}")
	    public void deleteById(@PathVariable("id") int id) {
	        this.WashPackService.deleteById(id);
	    }
	 
	 //update washPack 
//	 @PutMapping("/")
//	 public ResponseEntity<WashPack>update(@io.swagger.v3.oas.annotations.parameters.RequestBody WashPack pack)
//	 {
//		 return  ResponseEntity.ok(this.WashPackService.updateById(pack));
//	 }
//	 
//	 
	 @PutMapping("/update-pack")
	    public ResponseEntity<WashPack> updateWashPack(@RequestBody WashPack washpacks)
	    {
	        String methodName = "(updateWashPack)";
	        try {
	            logger.info(methodName + "Called");
	            return ResponseEntity.ok(this.WashPackService.updateWashPack(washpacks));
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            logger.error(methodName,"Something went wrong!!!!");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
//	 @PutMapping("/update/")
//	    public ResponseEntity<WashPack> updateCustomer(@RequestBody WashPack pack, @PathVariable("id") int id) {
//	    	 String methodName="(Update Data  Of WashPAck)";
//		        logger.info(methodName+"Called");
//	        WashPack pack1 = null;
//	        try {
//	            pack = WashPackService.updateById(pack);
//	            return ResponseEntity.ok().body(pack1);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	        }
//	    }
	//this is use to get WashPack by id
		@GetMapping(("/getwashpack/{id}"))
//		public WashPack wash(@PathVariable("id") int id)
//		{
//			return this.WashPackService.getWashPackByid(id);
//		}
	    public ResponseEntity<WashPack> getWashPackById(@PathVariable("id") int id) {
			 String methodName="(Get Data  Of WashPAck by id)";
		        logger.info(methodName+"Called");

	        try {
	            WashPack wash = WashPackService.getWashPackByid(id);
	            return ResponseEntity.of(Optional.of(wash));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }

	    }
	 

	 
	 
	 
	 //For Rating
	 
	 //TO GET RATINGS
	    
	    @GetMapping("/ratings")
	    public ResponseEntity<List<ReviewAndRating>> getAllRating() {
	    	try {
	    	List<ReviewAndRating> list = reviewAndRatingService.giveRatingAndReview();
	        return ResponseEntity.of(Optional.of(list));
	    } catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    	}
	    }
	    //TO ADD REVIEW AND RATING
	    @PostMapping("/rating")
		public ResponseEntity<ReviewAndRating> addRating(@RequestBody ReviewAndRating ratings)
		{
			try {
					reviewAndRatingService.addRating(ratings);
					return ResponseEntity.ok().body(ratings);
				}
			catch(Exception e){
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
	//To get all Washer By Rest Template
	    @GetMapping("/allWasher")
	    public List<Washers> getWashers()
	    {
	 	   String baseurl="http://localhost:8704/washer/";
	 	  Washers[] washers=restTemplate.getForObject(baseurl,Washers[].class);
	 	   return Arrays.asList(washers);   
	 	   }
	    

	    @GetMapping("/allCustomer")
	    public List<Customers> getCustomers()
	    {
	 	   String baseurl="http://localhost:8700/customers/getall";
	 	  Customers[] customers=restTemplate.getForObject(baseurl,Customers[].class);
	 	   return Arrays.asList(customers);   
	 	   }
	    
	    
	    
	    //LEADERBOARD CONTROLLER
	    
	    //To add washer based on ranking
	    
	    @PostMapping("/leaderboard")
	    public ResponseEntity<Leaderboard> addToLeaderboard(@RequestBody Leaderboard leaderboard) {

	        String methodName = "(addToLeaderboard)";

	        try {
	            logger.info(methodName + "Called");
	            leaderboardService.addNewWasherToLeaderboard(leaderboard);
	            return ResponseEntity.ok(leaderboard);
	        }
	        catch (Exception e){
	            e.printStackTrace();
	            logger.error(methodName,"Something went wrong!!!!");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
	    
	    //To get leaderboard based on ranking
	    @GetMapping("/get-leaderboard")
	    public ResponseEntity<List<Leaderboard>> washerLeaderboard() {

	        String methodName = "(washerLeaderboard)";

	        try {
	            logger.info(methodName + "Called");
	            List<Leaderboard> list = leaderboardService.getWasherLeaderboard();
	            return ResponseEntity.ok().body(list);
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            logger.error(methodName,"Something went wrong!!!!");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
	    
	    // to update Leaderboard
	    
	    @PutMapping("/update-leaderboard")
	    public Leaderboard updateLeaderBoard(@RequestBody Leaderboard leaderboard)
	    {
	    	 leaderboardService.updateLeaderboard(leaderboard);
	        return leaderboard;
	    }
	    
	    //to get leaderboard by rank
	    
	    @GetMapping("/getrank/{rank}")
	    public ResponseEntity<Leaderboard> getLeaderBoardByRank(@PathVariable("rank") long rank) {
			 String methodName="(Get Data  Of Leaderboard by Rank)";
		        logger.info(methodName+"Called");

	        try {
	            Leaderboard leader =  leaderboardService.findByrank(rank);
	            return ResponseEntity.of(Optional.of(leader));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }

	    }

	    //To manage Order
	    @GetMapping("/allOrders")
		public List<orderDetails> getOrders() {
			String baseurl = "http://localhost:8707/order/getall";
			orderDetails[] orders = restTemplate.getForObject(baseurl, orderDetails[].class);
			return Arrays.asList(orders);
		}
	   
		
	

	
}

package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class FallbackController {

	    @GetMapping("/ContactServiceFallback")
	    public String userServiceFallback(){
	        return "Contact-Service is down at this time !!!!," +
	                "Please try again later";
	    }

}
	
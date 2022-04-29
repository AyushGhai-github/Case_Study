package com.customerdetails.services;

import java.util.List;

import com.customerdetails.model.ReviewAndRating;




public interface ReviewAndRatingService {
	
	 public List<ReviewAndRating> giveRatingAndReview();
	 
	 public void addRating(ReviewAndRating rating);
}

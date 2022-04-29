package com.carDetails.Service;

import java.util.List;

import com.carDetails.model.ReviewAndRating;



public interface ReviewAndRatingService {
	
	 public List<ReviewAndRating> giveRatingAndReview();
	 
	 public void addRating(ReviewAndRating rating);
}

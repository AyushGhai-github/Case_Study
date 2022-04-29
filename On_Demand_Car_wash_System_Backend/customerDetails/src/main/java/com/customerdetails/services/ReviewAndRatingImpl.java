package com.customerdetails.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerdetails.model.ReviewAndRating;
import com.customerdetails.repository.ReviewAndRatingRepository;




@Service
public class ReviewAndRatingImpl implements ReviewAndRatingService {
	
	@Autowired
	private ReviewAndRatingRepository reviewAndRatingRepository;
	
	@Override
	public List<ReviewAndRating> giveRatingAndReview() {
		
		return reviewAndRatingRepository.findAll();
	}

	@Override
	public void addRating(ReviewAndRating rating) {
		System.out.println(rating);
		reviewAndRatingRepository.save(rating);
		
		
	}
	

}

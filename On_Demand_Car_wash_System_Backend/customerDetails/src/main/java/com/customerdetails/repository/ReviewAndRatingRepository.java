package com.customerdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.customerdetails.model.ReviewAndRating;

public interface ReviewAndRatingRepository  extends MongoRepository<ReviewAndRating,Integer>{

}

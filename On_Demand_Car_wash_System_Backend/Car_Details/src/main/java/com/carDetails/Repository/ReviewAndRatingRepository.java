package com.carDetails.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carDetails.model.ReviewAndRating;


public interface ReviewAndRatingRepository  extends MongoRepository<ReviewAndRating,Integer>{

}

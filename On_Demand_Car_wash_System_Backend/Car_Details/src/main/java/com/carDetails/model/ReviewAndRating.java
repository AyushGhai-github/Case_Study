package com.carDetails.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Rating")
public class ReviewAndRating {
	
	 @NotEmpty(message = "please review the washer, review can't be empty!")
	 private String Review;
	 private int Rating;
	 
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public ReviewAndRating(@NotEmpty(message = "please review the washer, review can't be empty!") String review,
			int rating) {
		super();
		Review = review;
		Rating = rating;
	}
	public ReviewAndRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	
	 

}

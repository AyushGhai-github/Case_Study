package com.washerDetails.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.washerDetails.model.Washers;

@Repository
public interface washerRepo extends MongoRepository<Washers,Integer> {
	
	public Washers findBy(int id);
	   public Washers findBywasherName(String name);

}

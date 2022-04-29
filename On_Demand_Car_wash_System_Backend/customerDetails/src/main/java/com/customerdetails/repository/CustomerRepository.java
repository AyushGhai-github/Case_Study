package com.customerdetails.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customerdetails.model.Customers;




@Repository
public interface CustomerRepository extends MongoRepository<Customers,Integer>{
	
	public Customers findBycustomerId(int id);
	
    public Customers findByUsername(String username);
    
    public Customers findByCustomerName(String name);

    
}

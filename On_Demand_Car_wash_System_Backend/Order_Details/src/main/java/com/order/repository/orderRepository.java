package com.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.model.orderDetails;

@Repository
public interface orderRepository extends MongoRepository<orderDetails, Integer> {

	public orderDetails findByorderId(int id);

	public orderDetails findBycustomerName(String name);

}

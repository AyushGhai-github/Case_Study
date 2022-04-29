package com.carDetails.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carDetails.model.WashPack;


@Repository
public interface WashPackRepository extends MongoRepository<WashPack,Integer> {

	public WashPack findByid(int id);
}

package com.washerDetails.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.washerDetails.Repo.washerRepo;
import com.washerDetails.model.Washers;

@Service
public class washerServiceImpl implements washerService {

	@Autowired
	private washerRepo repo;
	@Override
	public List<Washers> getAllWashers() {
		return repo.findAll();
	}

	@Override
	public Washers getWashersById(int id) {
		
		 return repo.findBy(id);
	}

	@Override
	public Washers findByWasherName(String name) {
		
		Washers washer = repo.findAll().stream()
				.filter(a -> a.getWasherName().equalsIgnoreCase(name)).findAny().orElseThrow(null);
			 return washer;
	}

	@Override
	public void setWashers(Washers washer) {
		Random random=new Random();
		washer.setId(random.nextInt(9999));
		washer.setRole("Washer");
		repo.save(washer);
		
	}

	@Override
	public Washers updateWasherById(Washers washer) {
		
		return repo.save(washer);
	}

	@Override
	public void deleteById(int id) {
		Washers washer=new Washers();
		repo.deleteById(id);
	}

}

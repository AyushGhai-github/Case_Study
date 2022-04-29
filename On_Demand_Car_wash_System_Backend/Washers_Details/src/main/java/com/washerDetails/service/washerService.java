package com.washerDetails.service;

import java.util.List;

import com.washerDetails.model.Washers;



public interface washerService 
{
public List<Washers> getAllWashers();
	
	public Washers getWashersById(int id);
	
	public Washers findByWasherName(String name);
	
	public void setWashers(Washers washer);
	
	public Washers updateWasherById(Washers washer);
	
	 public void deleteById(int id);
	
//	public void deleteCustomerById(int id);
}

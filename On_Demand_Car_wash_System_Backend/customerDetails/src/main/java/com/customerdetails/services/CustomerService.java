package com.customerdetails.services;

import java.util.List;

import com.customerdetails.model.Customers;

public interface CustomerService {
	
	//For Customer Details
	public List<Customers> getAllCustomers();
	
	public Customers getCustomerById(int id);
	
	public Customers findByCustomerName(String name);

	public void setCustomers(Customers customer);
	
	public Customers updateCustomerById(Customers customer);
	
	public void deleteCustomerById(int id);
	
	public Customers findByUsername(String username);


	
	

}

package com.customerdetails.services;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerdetails.exceptions.CustomerNotFoundException;
import com.customerdetails.model.Customers;
import com.customerdetails.repository.CustomerRepository;




@Service
public class CustomerServiceImpl implements CustomerService {
  
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public List<Customers> getAllCustomers() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customers getCustomerById(int id) {
		
		return customerRepository.findBycustomerId(id);
	}

	@Override
	public void setCustomers(Customers customer) {
		customerRepository.save(customer);		
	}

	@Override
	public Customers updateCustomerById(Customers customer) {
	
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(int id) {
		customerRepository.deleteById(id);
		
	}


	@Override
	public Customers findByCustomerName(String name) {
		Customers customer = customerRepository.findAll().stream()
				.filter(a -> a.getUsername().equalsIgnoreCase(name)).findAny().orElseThrow(null);
		if (customer == null) {

			throw new CustomerNotFoundException(
					"Customer with the provided name is not found, please use the name which was used at the time of registration!");

		} else {
			return customer;
		}
	}

	public Object addCustomer(Customers customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override

		// TODO Auto-generated method stub
		public Customers findByUsername(String username) {
			Customers customer = customerRepository
	                .findAll()
	                .stream()
	                .filter(a -> a.getUsername().equalsIgnoreCase(username))
	                .findAny().orElse(null);
			if (customer == null) {
				throw new CustomerNotFoundException("Sorry, Customer with the provided Username not found" +
						",Please provide the correct Username");
			}
			else {
				return customerRepository.findByUsername(username);
			}
		}

	}
		
		



	
	
	

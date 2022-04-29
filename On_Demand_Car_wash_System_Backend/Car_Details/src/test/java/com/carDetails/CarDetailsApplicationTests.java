package com.carDetails;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cardetails.model.Customers;
import com.cardetails.services.CustomerServiceImpl;



class CustomerServiceImplTest {

	CustomerServiceImpl customerServiceImplMock = mock(CustomerServiceImpl.class);

	@Test
	@DisplayName("Find customer by Name")
	void findByName() {
		Customers customer = new Customers(1, "ayush", "pass","ayushghai65@gmail.com","Ayush", "Address",98709,false, "true", "CUSTOMER");
		when(customerServiceImplMock.findByCustomerName("customer")).thenReturn(customer);
			
	}
	
	@Test
	@DisplayName("Add customer")
	void addCustomer() {
		Customers customer = new Customers(1, "ayush", "pass","ayushghai65@gmail.com","Ayush", "Address",98709,false, "true", "CUSTOMER");
		when(customerServiceImplMock.addCustomer(customer)).thenReturn(customer);
				
		assertEquals(customer, customerServiceImplMock.addCustomer(customer));
	
	}

	@Test
	void updateProfile() {
		Customers customer = new Customers(1, "ayush", "pass","ayushghai65@gmail.com","Ayush", "Address",98709,false, "true", "CUSTOMER");
		when(customerServiceImplMock.updateCustomerById(customer)).thenReturn(customer);
		assertEquals(customer, customerServiceImplMock.updateCustomerById(customer));
		
	}
}

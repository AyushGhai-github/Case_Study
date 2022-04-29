package com.washerDetails;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.washerDetails.model.Washers;
import com.washerDetails.service.washerServiceImpl;



class CustomerServiceImplTest {

	washerServiceImpl washerServiceImplMock = mock(washerServiceImpl.class);

	@Test
	@DisplayName("Find washer by name")
	void findByName() {
		Washers washer = new Washers(1, "ayush", "pass","ayushghai65@gmail.com",98709, "Address","Ayush", "Washer");
		when(washerServiceImplMock.findByWasherName("washer")).thenReturn(washer);
			
	}
//	
//	@Test
//	@DisplayName("Add washer")
//	void addWasher() {
//		Washers washer = new Washers(1, "ayush", "pass","ayushghai65@gmail.com",98709, "Address","Ayush", "Washer");
//		when(washerServiceImplMock.setWashers(washer)).thenReturn(washer);
//				
//		assertEquals(washer, washerServiceImplMock.setWashers(washer));
//	
//	
//	}

	@Test
	void updateProfile() {
		Washers washer = new Washers(1, "ayush", "pass","ayushghai65@gmail.com",98709, "Address","Ayush", "Washer");;
		when(washerServiceImplMock.updateWasherById(washer)).thenReturn(washer);
		assertEquals(washer, washerServiceImplMock.updateWasherById(washer));
		
	}
}
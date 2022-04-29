package com.washerDetails.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Washers")
public class Washers {
	private int id;
	private String username;
	private String password;
	private String washerName;
	private double contactNo;
	private String washerEmail;
	private String washerAddress;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public double getContactNo() {
		return contactNo;
	}
	public void setContactNo(double contactNo) {
		this.contactNo = contactNo;
	}
	public String getWasherEmail() {
		return washerEmail;
	}
	public void setWasherEmail(String washerEmail) {
		this.washerEmail = washerEmail;
	}
	public String getWasherAddress() {
		return washerAddress;
	}
	public void setWasherAddress(String washerAddress) {
		this.washerAddress = washerAddress;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Washers(int id, String username, String password, String washerName, double contactNo, String washerEmail,
			String washerAddress, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.washerName = washerName;
		this.contactNo = contactNo;
		this.washerEmail = washerEmail;
		this.washerAddress = washerAddress;
		this.role = role;
	}
	public Washers() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

	
}

package com.carDetails.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="Customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customers {
	
//	@Id
	private int customerId;
	private String userName;
	private String password;
	@Email(message = "Provide a valid E-mail Address ! ")
	private String customerEmail;
	@NotEmpty(message = "Name cannot be null, Please enter your name !")
	private String customerName;
	@NotEmpty(message = "Please provide the address for the washer partner to reach your destination.")
	private String customerAddress;
	private double customerContactNo;
	private boolean enabled=true;
	private String profile;
	private String role;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public double getCustomerContactNo() {
		return customerContactNo;
	}
	public void setCustomerContactNo(double customerContactNo) {
		this.customerContactNo = customerContactNo;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Customers(int customerId, String userName, String password,
			@Email(message = "Provide a valid E-mail Address ! ") String customerEmail,
			@NotEmpty(message = "Name cannot be null, Please enter your name !") String customerName,
			@NotEmpty(message = "Please provide the address for the washer partner to reach your destination.") String customerAddress,
			double customerContactNo, boolean enabled, String profile, String role) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.password = password;
		this.customerEmail = customerEmail;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerContactNo = customerContactNo;
		this.enabled = enabled;
		this.profile = profile;
		this.role = role;
	}
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
	
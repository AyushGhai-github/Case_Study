package com.order.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Orders")
public class orderDetails {
	@Id
	private int orderId;
	private String customerName;
	private String customerEmail;
	private String customerAddress;
	private String customerContactNo;
	private String carName;
	private String carNo;
	private String selectedWashpack;
	private String date;
	private String time;
	private double totalAmount;
	private String paymentStatus;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerContactNo() {
		return customerContactNo;
	}

	public void setCustomerContactNo(String customerContactNo) {
		this.customerContactNo = customerContactNo;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getSelectedWashpack() {
		return selectedWashpack;
	}

	public void setSelectedWashpack(String selectedWashpack) {
		this.selectedWashpack = selectedWashpack;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public orderDetails(int orderId, String customerName, String customerEmail, String customerAddress,
			String customerContactNo, String carName, String carNo, String selectedWashpack, String date, String time,
			double totalAmount, String paymentStatus) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.customerContactNo = customerContactNo;
		this.carName = carName;
		this.carNo = carNo;
		this.selectedWashpack = selectedWashpack;
		this.date = date;
		this.time = time;
		this.totalAmount = totalAmount;
		this.paymentStatus = paymentStatus;
	}

	public orderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "orderDetails [orderId=" + orderId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerAddress=" + customerAddress + ", customerContactNo=" + customerContactNo
				+ ", carName=" + carName + ", carNo=" + carNo + ", selectedWashpack=" + selectedWashpack + ", date="
				+ date + ", time=" + time + ", totalAmount=" + totalAmount + ", paymentStatus=" + paymentStatus + "]";
	}

}
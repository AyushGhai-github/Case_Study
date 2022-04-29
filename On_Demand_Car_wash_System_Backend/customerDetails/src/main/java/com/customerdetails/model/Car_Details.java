package com.customerdetails.model;

public class Car_Details {

	private String carName;
	private String carType;
	private String carNo;
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public Car_Details(String carName, String carType, String carNo) {
		super();
		this.carName = carName;
		this.carType = carType;
		this.carNo = carNo;
	}
	public Car_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Car_Details [carName=" + carName + ", carType=" + carType + ", carNo=" + carNo + "]";
	}
	
	
}

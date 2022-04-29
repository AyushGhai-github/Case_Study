package com.carDetails.model;

import org.springframework.data.mongodb.core.mapping.Document;

import nonapi.io.github.classgraph.json.Id;

@Document(collection = "WashPackages")
public class WashPack {

	@Id
	private int id;
	private String packName;
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public WashPack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WashPack(int id, String packName, double amount) {
		super();
		this.id = id;
		this.packName = packName;
		this.amount = amount;
	}

}

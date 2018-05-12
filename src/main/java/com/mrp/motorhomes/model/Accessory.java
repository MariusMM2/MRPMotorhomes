package com.mrp.motorhomes.model;

public class Accessory {

	private String name;
	private int rentId;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRentId() {
		return this.rentId;
	}

	public void setRentId(int rentId) {
		this.rentId = rentId;
	}

	public Accessory() {

	}

	/**
	 * 
	 * @param name
	 * @param rentId
	 */
	public Accessory(String name, int rentId) {

	}

	/**
	 * 
	 * @param name
	 */
	public Accessory(String name) {

	}

}
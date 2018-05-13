package com.mrp.motorhomes.model;

public class Accessory {
	
	public static final Accessory[] ALL_ACCESSORIES = {new Accessory("Bike rack"), new Accessory("Bed linen"), new Accessory("Picnic table and chairs"), new Accessory("Child seat"), new Accessory("TV"), new Accessory("Fishing tools")};

	private String title;
	private int rentalId;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRentalId() {
		return this.rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public Accessory() {

	}

	/**
	 * 
	 * @param title
	 * @param rentalId
	 */
	public Accessory(String title, int rentalId) {
		this.title = title;
		this.rentalId = rentalId;
	}

	/**
	 *
	 * @param title
	 */
	public Accessory(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Accessory{" +
					   "title='" + title + '\'' +
					   ", rentalId=" + rentalId +
					   '}';
	}
}
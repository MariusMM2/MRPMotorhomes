package com.mrp.motorhomes.model;

public class Accessory {

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
	
	@Override
	public String toString() {
		return "Accessory{" +
					   "title='" + title + '\'' +
					   ", rentalId=" + rentalId +
					   '}';
	}
}
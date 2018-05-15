package com.mrp.motorhomes.model;

public class Accessory {
	
	public static final String[] ALL_ACCESSORIES = {
			"Bike rack", "Bed linen", "Picnic table and chairs", "Child seat", "TV", "Fishing tools"};

	private String title;
	
	public Accessory(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Accessory{" +
					   "title='" + title + '\'' +
					   '}';
	}
}
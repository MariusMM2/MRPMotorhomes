package com.mrp.motorhomes.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class RentalView extends Rental {
	
	private String customerName;
	private String motorhomeName;
	private ArrayList<Accessory> accessories;
	
	public RentalView(int id, String customerName, String motorhomeName, double price, LocalDate startDate,
					  LocalDate endDate, String pickUp, String dropOff) {
		super(id, -1,-1, price, startDate, endDate, pickUp, dropOff);
		this.customerName = customerName;
		this.motorhomeName = motorhomeName;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public String getMotorhomeName() {
		return motorhomeName;
	}
	
	@Override
	public ArrayList<Accessory> getAccessories() {
		return accessories;
	}
	
	@Override
	public void setAccessories(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}
}

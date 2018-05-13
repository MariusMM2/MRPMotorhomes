package com.mrp.motorhomes.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class RentalView extends Rental {
	
	private String customerName;
	private String motorhomeName;
	private ArrayList<Accessory> accessories;
	
	public RentalView(int id, int customersId, String customerName, int motorhomeId, String motorhomeName,
					  double price, LocalDate startDate, LocalDate endDate, String pickUp, String dropOff) {
		super(id, customersId,motorhomeId, price, startDate, endDate, pickUp, dropOff);
		this.customerName = customerName;
		this.motorhomeName = motorhomeName;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getMotorhomeName() {
		return motorhomeName;
	}
	
	public void setMotorhomeName(String motorhomeName) {
		this.motorhomeName = motorhomeName;
	}
	
	@Override
	public ArrayList<Accessory> getAccessories() {
		return accessories;
	}
	
	@Override
	public void setAccessories(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}
	
	@Override
	public String toString() {
		return "RentalView{" +
					   "customerName='" + customerName + '\'' +
					   ", motorhomeName='" + motorhomeName + '\'' +
					   ", accessories=" + accessories +
					   ", id=" + id +
					   ", customerId=" + customerId +
					   ", motorhomeId=" + motorhomeId +
					   ", price=" + price +
					   ", startDate=" + startDate +
					   ", endDate=" + endDate +
					   ", pickUp='" + pickUp + '\'' +
					   ", dropOff='" + dropOff + '\'' +
					   ", accessories=" + accessories +
					   '}';
	}
}

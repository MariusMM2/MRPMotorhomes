package com.mrp.motorhomes.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;

public class Rental {

	private int id;
	private int customerId;
	private int motorhomeId;
	protected double price;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	private String pickUp;
	private String dropOff;
	private boolean paid;
	private String customerName;
	private String motorhomeName;
	private ArrayList<Accessory> accessories;
	
	public Rental() {

	}
	
	public Rental(int id, int customerId, String customerName, int motorhomeId, String motorhomeName,
				  double price, LocalDate startDate, LocalDate endDate, String pickUp, String dropOff, boolean paid) {
		this.id = id;
		this.customerId = customerId;
		this.motorhomeId = motorhomeId;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pickUp = pickUp;
		this.dropOff = dropOff;
		this.paid = paid;
		this.customerName = customerName;
		this.motorhomeName = motorhomeName;
	}
	
	public Rental(int customerId, int motorhomeId, double price, LocalDate startDate, LocalDate endDate,
				  String pickUp, String dropOff, boolean paid,
				  ArrayList<Accessory> accessories) {
		this.customerId = customerId;
		this.motorhomeId = motorhomeId;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pickUp = pickUp;
		this.dropOff = dropOff;
		this.paid = paid;
		this.accessories = accessories;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getMotorhomeId() {
		return this.motorhomeId;
	}

	public void setMotorhomeId(int motorhomeId) {
		this.motorhomeId = motorhomeId;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getPickUp() {
		return this.pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public String getDropOff() {
		return this.dropOff;
	}

	public void setDropOff(String dropOff) {
		this.dropOff = dropOff;
	}
	
	public boolean isPaid() {
		return paid;
	}
	
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public ArrayList<Accessory> getAccessories() {
		return this.accessories;
	}

	public void setAccessories(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}
	
	public boolean isEnded(){
		return endDate.isBefore(LocalDate.now());
	}
	
	@Override
	public String toString() {
		return "Rental{" +
					   "id=" + id +
					   ", customerId=" + customerId +
					   ", motorhomeId=" + motorhomeId +
					   ", price=" + price +
					   ", startDate=" + startDate +
					   ", endDate=" + endDate +
					   ", pickUp='" + pickUp + '\'' +
						", dropOff='" + dropOff + '\'' +
						", paid='" + paid + '\'' +
					   ", accessories=" + accessories +
					   '}';
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
}
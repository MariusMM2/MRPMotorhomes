package com.mrp.motorhomes.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;

public class Rental {

	private int id;
	private int customerId;
	private int motorhomeId;
	private double price;
	/**
	 * @DateTimeFormat(pattern = "yyyy-MM-dd")
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	private String pickUp;
	private String dropOff;
	private ArrayList<Accessory> accessories;
	
	public Rental() {

	}
	
	/**
	 *
	 * @param id
	 * @param customerId
	 * @param motorhomeId
	 * @param price
	 * @param startDate
	 * @param endDate
	 * @param pickUp
	 * @param dropOff
//	 * @param accessories
	 */
	public Rental(int id, int customerId, int motorhomeId, double price, LocalDate startDate, LocalDate endDate, String pickUp, String dropOff) {
		this.id = id;
		this.customerId = customerId;
		this.motorhomeId = motorhomeId;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pickUp = pickUp;
		this.dropOff = dropOff;
	}

//	public Rental(int id, int customerId, int motorhomeId, double price, LocalDate startDate, LocalDate endDate, String pickUp, String dropOff, ArrayList<Accessory> accessories) {
//		this.id = id;
//		this.customerId = customerId;
//		this.motorhomeId = motorhomeId;
//		this.price = price;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.pickUp = pickUp;
//		this.dropOff = dropOff;
//		this.accessories = accessories;
//		throw new UnsupportedOperationException();
//	}

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

	public ArrayList<Accessory> getAccessories() {
		return this.accessories;
	}

	public void setAccessories(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}
}
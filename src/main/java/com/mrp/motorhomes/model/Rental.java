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
	private LocalDate endDate;
	private String pickup;
	private String dropoff;
	private ArrayList<Accessory> accessories;
	
	public Rental() {
		// TODO - implement Rental.Rental
		throw new UnsupportedOperationException();
	}
	
	/**
	 *
	 * @param id
	 * @param customerId
	 * @param motorhomeId
	 * @param price
	 * @param startDate
	 * @param endDate
	 * @param pickup
	 * @param dropoff
	 * @param accessories
	 */
	public Rental(int id, int customerId, int motorhomeId, double price, LocalDate startDate, LocalDate endDate, String pickup, String dropoff, ArrayList<Accessory> accessories) {
		// TODO - implement Rental.Rental
		throw new UnsupportedOperationException();
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

	public String getPickup() {
		return this.pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getDropoff() {
		return this.dropoff;
	}

	public void setDropoff(String dropoff) {
		this.dropoff = dropoff;
	}

	public ArrayList<Accessory> getAccessories() {
		return this.accessories;
	}

	public void setAccessories(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}
}
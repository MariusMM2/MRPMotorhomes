package com.mrp.motorhomes.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Motorhome {

	public static final String[] TYPES = {"Class A", "Class B", "Class C", "Truck Camper", "Popup Camper", "Travel Trailer", "Teardrop Trailer", "Hybrid Trailer"};
	public static final Accessory[] ALL_ACCESSORIES = {new Accessory("Bike rack"), new Accessory("Bed linen"), new Accessory("Picnic table and chairs"), new Accessory("Child seat"), new Accessory("TV"), new Accessory("Fishing tools")};
	private int id;
	private String brand;



    private String type;
	private String model;
	private String year;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate lastService;
	private double basePrice;

    /**
     *
     * @param id
     * @param brand
     * @param type
     * @param model
     * @param year
	 * @param lastService
     * @param basePrice
     */


	public Motorhome(int id, String brand, String type, String model, String year, LocalDate lastService, double basePrice) {
		this.id = id;
		this.brand = brand;
		this.type = type;
		this.model = model;
		this.year = year;
		this.lastService = lastService;
		this.basePrice = basePrice;
	}

    public Motorhome() {}


    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

    public LocalDate getLastService() {
        return lastService;
    }

    public void setLastService(LocalDate lastService) {
        this.lastService = lastService;
    }
	public double getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

}
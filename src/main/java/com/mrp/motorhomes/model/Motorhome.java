package com.mrp.motorhomes.model;

public class Motorhome {

	public static final String[] TYPES = {"Class A", "Class B", "Class C", "Truck Camper", "Popup Camper", "Travel Trailer", "Teardrop Trailer", "Hybrid Trailer"};
	private int id;
	private String brand;
	private String type;
	private String model;
	private String year;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate lastService;
	public final Accessory[] ALL_ACCESSORIES = {new Accessory("Bike rack"), new Accessory("Bed linen"), new Accessory("Picnic table and chairs"), new Accessory("Child seat"), new Accessory("TV"), new Accessory("Fishing tools")};
	private final double basePrice;

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

	public double getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public Motorhome() {
		// TODO - implement Motorhome.Motorhome
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param brand
	 * @param type
	 * @param model
	 * @param year
	 * @param basePrice
	 */
	public Motorhome(int id, String brand, String type, String model, String year, double basePrice) {

	}

}
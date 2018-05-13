package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.model.Accessory;

import java.util.ArrayList;

public class AccessoryRepository extends CrudRepository<Accessory> {

	private static AccessoryRepository instance;
	public static AccessoryRepository getInstance(){
		if(instance == null){
			instance = new AccessoryRepository();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param item
	 */
	public void create(Accessory item) {
		// TODO - implement AccessoryRepository.create
		throw new UnsupportedOperationException();
	}

	public ArrayList<Accessory> readAll() {
		// TODO - implement AccessoryRepository.readAll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Accessory read(int id) {
		// TODO - implement AccessoryRepository.read
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void update(Accessory item) {
		// TODO - implement AccessoryRepository.update
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public void delete(int id) {
		// TODO - implement AccessoryRepository.delete
		throw new UnsupportedOperationException();
	}

}
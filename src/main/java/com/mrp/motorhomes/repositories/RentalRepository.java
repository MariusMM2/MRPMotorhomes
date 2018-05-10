package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.model.Rental;

import java.util.ArrayList;

public class RentalRepository extends CrudRepository<Rental> {

	/**
	 * 
	 * @param item
	 */
	@Override
	public void create(Rental item) {
		// TODO - implement RentalRepository.create
		throw new UnsupportedOperationException();
	}
	
	@Override
	public ArrayList<Rental> readAll() {
		// TODO - implement RentalRepository.readAll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public Rental read(int id) {
		// TODO - implement RentalRepository.read
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	@Override
	public void update(Rental item) {
		// TODO - implement RentalRepository.update
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		// TODO - implement RentalRepository.delete
		throw new UnsupportedOperationException();
	}

}
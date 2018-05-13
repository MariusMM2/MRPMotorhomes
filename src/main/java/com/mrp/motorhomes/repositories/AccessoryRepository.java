package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.model.Accessory;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccessoryRepository extends CrudRepository<ArrayList<Accessory>> {

	private static AccessoryRepository instance;
	public static AccessoryRepository getInstance(){
		if(instance == null){
			instance = new AccessoryRepository();
		}
		return instance;
	}
	
	@Override
	public void create(ArrayList<Accessory> item) {
		// TODO - implement AccessoryRepository.create
		throw new UnsupportedOperationException();
	}
	
	@Override
	public ArrayList<ArrayList<Accessory>> readAll() {
		// TODO - implement AccessoryRepository.create
		throw new UnsupportedOperationException();
	}
	
	@Override
	public ArrayList<Accessory> read(int id) {
		ArrayList<Accessory> accessories = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rented_accessories WHERE rentalId=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				accessories.add(new Accessory(
						resultSet.getString("title"),
						resultSet.getInt("rentalId")));
			}
			return accessories;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void update(ArrayList<Accessory> item) {
		// TODO - implement AccessoryRepository.create
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void delete(int id) {
		// TODO - implement AccessoryRepository.create
		throw new UnsupportedOperationException();
	}
}
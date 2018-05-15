package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.model.Accessory;

import java.sql.Date;
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
	public void create(ArrayList<Accessory> accessories) {
		refreshConnection();
		// TODO - implement AccessoryRepository.create
		
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO rented_accessories(title, rentalId) VALUES (?, ?)");
			for(Accessory accessory : accessories){
				preparedStatement.setString(1, accessory.getTitle());
				preparedStatement.setInt(2, accessory.getRentalId());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@Deprecated
	public ArrayList<ArrayList<Accessory>> readAll() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public ArrayList<Accessory> read(int id) {
		refreshConnection();
		ArrayList<Accessory> accessories = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rented_accessories WHERE rentalId=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				accessories.add(new Accessory(
						resultSet.getString("title"),
						id));
			}
			return accessories;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void update(ArrayList<Accessory> item) {
		refreshConnection();
		// TODO - implement AccessoryRepository.create
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void delete(int id) {
		refreshConnection();
		// TODO - implement AccessoryRepository.create
		throw new UnsupportedOperationException();
	}
}
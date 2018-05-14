package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.model.Rental;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentalRepository extends CrudRepository<Rental> {
	
	private static RentalRepository instance;
	public static RentalRepository getInstance(){
		if(instance == null){
			instance = new RentalRepository();
		}
		return instance;
	}

	/**
	 * 
	 * @param item
	 */
	@Override
	public void create(Rental item) {
		refreshConnection();
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO rentals(customerId, motorhomeId, price, startDate, endDate, pickUp, dropOff, paid) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, item.getCustomerId());
			preparedStatement.setInt(2, item.getMotorhomeId());
			preparedStatement.setDouble(3, item.getPrice());
			preparedStatement.setDate(4, Date.valueOf(item.getStartDate()));
			preparedStatement.setDate(5, Date.valueOf(item.getEndDate()));
			preparedStatement.setString(6, item.getPickUp());
			preparedStatement.setString(7, item.getDropOff());
			preparedStatement.setBoolean(8, item.getIsPaid());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Rental> readAll() {
		refreshConnection();
		ArrayList<Rental> rentals = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT rentals.id, rentals.customerId, customers.firstName, customers.lastName, " +
							"rentals.motorhomeId, motorhomes.brand, motorhomes.model, rentals.price, rentals.startDate, " +
							"rentals.endDate, rentals.pickUp, rentals.dropOff, rentals.paid FROM rentals " +
							"INNER JOIN customers ON rentals.customerId=customers.id " +
							"INNER JOIN motorhomes ON rentals.motorhomeId=motorhomes.id");
			resultSet = preparedStatement.executeQuery();
			System.out.println("after prepS");
			while(resultSet.next()){
				rentals.add(new Rental(
						resultSet.getInt("id"),
						resultSet.getInt("customerId"),
						resultSet.getString("firstName") + " " + resultSet.getString("lastName"),
						resultSet.getInt("motorhomeId"),
						resultSet.getString("brand") + " " + resultSet.getString("model"),
						resultSet.getDouble("price"),
						resultSet.getDate("startDate").toLocalDate(),
						resultSet.getDate("endDate").toLocalDate(),
						resultSet.getString("pickUp"),
						resultSet.getString("dropOff"),
						resultSet.getBoolean("paid")));
			}
			return rentals;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public Rental read(int id) {
		refreshConnection();
		Rental rental = null;
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT rentals.id, rentals.customerId, customers.firstName, customers.lastName, " +
							"rentals.motorhomeId, motorhomes.brand, motorhomes.model, rentals.price, rentals.startDate, " +
							"rentals.endDate, rentals.pickUp, rentals.dropOff, rentals.paid FROM rentals " +
							"INNER JOIN customers ON rentals.customerId=customers.id " +
							"INNER JOIN motorhomes ON rentals.motorhomeId=motorhomes.id WHERE rentals.id=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				rental = new Rental(
						resultSet.getInt("id"),
						resultSet.getInt("customerId"),
						resultSet.getString("firstName") + " " + resultSet.getString("lastName"),
						resultSet.getInt("motorhomeId"),
						resultSet.getString("brand") + " " + resultSet.getString("model"),
						resultSet.getDouble("price"),
						resultSet.getDate("startDate").toLocalDate(),
						resultSet.getDate("endDate").toLocalDate(),
						resultSet.getString("pickUp"),
						resultSet.getString("dropOff"),
						resultSet.getBoolean("paid"));
				
				rental.setAccessories(AccessoryRepository.getInstance().read(rental.getId()));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rental;
	}

	/**
	 * 
	 * @param item
	 */
	@Override
	public void update(Rental item) {
		refreshConnection();

		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE rentals SET customerId=?, motorhomeId=?, price=?, startDate=?, endDate=?, pickUp=?, dropOff=?, paid=? WHERE id=?");
			preparedStatement.setInt(1, item.getCustomerId());
			preparedStatement.setInt(2, item.getMotorhomeId());
			preparedStatement.setDouble(3, item.getPrice());
			preparedStatement.setDate(4, Date.valueOf(item.getStartDate()));
			preparedStatement.setDate(5, Date.valueOf(item.getEndDate()));
			preparedStatement.setString(6, item.getPickUp());
			preparedStatement.setString(7, item.getDropOff());
			preparedStatement.setBoolean(8, item.getIsPaid());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public void delete(int id) {
		refreshConnection();
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM rentals WHERE id = ?");
			preparedStatement.setInt(1, id);

			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
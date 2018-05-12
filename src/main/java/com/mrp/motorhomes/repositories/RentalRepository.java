package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.model.Customer;
import com.mrp.motorhomes.model.Motorhome;
import com.mrp.motorhomes.model.Rental;
import com.mrp.motorhomes.repositories.util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentalRepository extends CrudRepository<Rental> {

	/**
	 * 
	 * @param item
	 */
	@Override
	public void create(Rental item) {
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO rentals(customerId, motorhomeId, price, startDate, endDate, pickUp, dropOff) VALUES (?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, item.getCustomerId());
			preparedStatement.setInt(2, item.getMotorhomeId());
			preparedStatement.setDouble(3, item.getPrice());
			preparedStatement.setDate(4, Date.valueOf(item.getStartDate()));
			preparedStatement.setDate(5, Date.valueOf(item.getEndDate()));
			preparedStatement.setString(6, item.getPickUp());
			preparedStatement.setString(7, item.getDropOff());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Rental> readAll() {
		ArrayList<Rental> rentals = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rentals");
			resultSet = preparedStatement.executeQuery();
			System.out.println("after prepS");
			while(resultSet.next()){
				rentals.add(new Rental(
						resultSet.getInt("id"),
						resultSet.getInt("customerId"),
						resultSet.getInt("motorhomeId"),
						resultSet.getDouble("price"),
						resultSet.getDate("startDate").toLocalDate(),
						resultSet.getDate("endDate").toLocalDate(),
						resultSet.getString("pickUp"),
						resultSet.getString("dropOff")));
			}
			System.out.println(rentals);
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
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rentals WHERE id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				return new Rental(
						resultSet.getInt("id"),
						resultSet.getInt("customerId"),
						resultSet.getInt("motorhomeId"),
						resultSet.getDouble("price"),
						resultSet.getDate("startDate").toLocalDate(),
						resultSet.getDate("endDate").toLocalDate(),
						resultSet.getString("pickUp"),
						resultSet.getString("dropOff"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param item
	 */
	@Override
	public void update(Rental item) {

		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE rentals SET customerId=?, motorhomeId=?, price=?, startDate=?, endDate=?, pickUp=?, dropOff=? WHERE id=?");
			preparedStatement.setInt(1, item.getCustomerId());
			preparedStatement.setInt(2, item.getMotorhomeId());
			preparedStatement.setDouble(3, item.getPrice());
			preparedStatement.setDate(4, Date.valueOf(item.getStartDate()));
			preparedStatement.setDate(5, Date.valueOf(item.getEndDate()));
			preparedStatement.setString(6, item.getPickUp());
			preparedStatement.setString(7, item.getDropOff());
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
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM rentals WHERE id = ?");
			preparedStatement.setInt(1, id);

			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
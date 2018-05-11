package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.model.Motorhome;
import com.mrp.motorhomes.model.Rental;

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

//		throw new UnsupportedOperationException();
	}
	
	@Override
	public ArrayList<Rental> readAll() {

		ArrayList<Rental> rentals = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rentals");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
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
		} catch (SQLException e) {
			e.printStackTrace();
		}


		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public Rental read(int id) {

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM motorhomes WHERE id = ?");
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

		//		throw new UnsupportedOperationException();
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
	@Override
	public void delete(int id) {
		// TODO - implement RentalRepository.delete
		throw new UnsupportedOperationException();
	}

}
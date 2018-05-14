package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.model.Motorhome;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class MotorhomeRepository extends CrudRepository<Motorhome> {
	
	private static MotorhomeRepository instance;
	public static MotorhomeRepository getInstance(){
		if(instance == null){
			instance = new MotorhomeRepository();
		}
		return instance;
	}

	/**
	 * 
	 * @param item
	 */
	@Override
	public void create(Motorhome item) {
		refreshConnection();
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO motorhomes(brand, type, model, year, lastService, basePrice) VALUES (?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, item.getBrand());
			preparedStatement.setString(2, item.getType());
			preparedStatement.setString(3, item.getModel());
			preparedStatement.setString(4, item.getYear());
			preparedStatement.setDate(5, Date.valueOf(item.getLastService()));
			preparedStatement.setDouble(6, item.getBasePrice());

			preparedStatement.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public ArrayList<Motorhome> readAll() {
		refreshConnection();
		ArrayList<Motorhome> motorhomes = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM motorhomes");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				motorhomes.add(new Motorhome(resultSet.getInt("id"),
						resultSet.getString("brand"),
						resultSet.getString("type"),
						resultSet.getString("model"),
						resultSet.getString("year"),
						resultSet.getDate("lastService").toLocalDate(),
						resultSet.getDouble("basePrice")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return motorhomes;
	}

	/**
	 *
	 * @param id
	 */
	@Override
	public Motorhome read(int id) {
		refreshConnection();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM motorhomes WHERE id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				return new Motorhome(resultSet.getInt("id"),
						resultSet.getString("brand"),
						resultSet.getString("type"),
						resultSet.getString("model"),
						resultSet.getString("year"),
						resultSet.getDate("lastService").toLocalDate(),
						resultSet.getDouble("basePrice"));
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
	public void update(Motorhome item) {
		refreshConnection();
		try {
			preparedStatement = connection.prepareStatement("UPDATE motorhomes SET brand = ?, type = ?, model = ?, year = ?, lastService = ?, basePrice = ? WHERE id = ?");
			preparedStatement.setString(1, item.getBrand());
			preparedStatement.setString(2, item.getType());
			preparedStatement.setString(3, item.getModel());
			preparedStatement.setString(4, item.getYear());
			preparedStatement.setDate(5, Date.valueOf(item.getLastService()));
			preparedStatement.setDouble(6, item.getBasePrice());
			preparedStatement.setInt(7, item.getId());

			preparedStatement.execute();
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
			preparedStatement = connection.prepareStatement("DELETE FROM motorhomes WHERE id = ?");
			preparedStatement.setInt(1, id);

			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
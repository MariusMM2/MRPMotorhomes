package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.repositories.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public abstract class CrudRepository<T>{

	protected static Connection connection;
	private   static long lastConnRefresh;
	protected static PreparedStatement preparedStatement;
	protected static ResultSet resultSet;
	
	protected CrudRepository(){}
	
	/**
	 * Adds a new element in the table
	 * @param item The element to be added in the table
	 */
	public abstract void create(T item);
	
	/**
	 * Reads all the elements of the table
	 * @return A list of all the elements
	 */
	public abstract ArrayList<T> readAll();

	/**
	 * Reads a specific element from the table
	 * @param id The id of the element
	 * @return The element itself
	 */
	public abstract T read(int id);

	/**
	 * Updates an existing element in the table
	 * @param item The element to be placed in the table
	 */
	public abstract void update(T item);

	/**
	 * Deletes an element from the table
	 * @param id The id of the element to be removed
	 */
	public abstract void delete(int id);
	
	/**
	 * Is called each time the application is accessing the database.
	 * On the first call, creates the connection and stores the time when created.
	 * Every time the method is called, if the time since the last refresh was more than five minute, rebuilds the
	 * connection.
	 */
	protected static void refreshConnection(){
		long currentTime = System.currentTimeMillis();
		//If the time since the last refresh is more than 5 minutes
		if( currentTime - lastConnRefresh > 1000*60*5){
			lastConnRefresh = currentTime;
			connection = DBConnection.getConnection();
		}
	}
}
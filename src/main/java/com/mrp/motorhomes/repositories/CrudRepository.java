package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.repositories.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class CrudRepository<T>{

	protected static Connection connection;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;

	//this scope is executed at the launch of the program
	static {
		//creates a Runnable object to hold the instructions for the refreshing thread
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while(true) {
					//System.out.println("refreshing");
					//reconnects to the database
					connection = DBConnection.getConnection();
					//sleeps for 10 minutes
					try {
						Thread.sleep(10 * 60 * 1000);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
					//closes the current connection
					try {
						connection.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//starts the thread on the runnable object
		new Thread(runnable, "Refresh Thread").start();
	}
	
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
}
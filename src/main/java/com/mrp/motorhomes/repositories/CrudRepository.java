package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.repositories.util.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class CrudRepository<T> {

	protected Connection connection = DBConnection.getConnection();

	/**
	 * 
	 * @param item
	 */
	public abstract void create(T item);

	public abstract ArrayList<T> readAll();

	/**
	 * 
	 * @param id
	 */
	public abstract T read(int id);

	/**
	 * 
	 * @param item
	 */
	public abstract void update(T item);

	/**
	 * 
	 * @param item
	 */
	public abstract void delete(T item);

}
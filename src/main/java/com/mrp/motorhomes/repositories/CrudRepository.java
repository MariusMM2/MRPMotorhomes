package com.mrp.motorhomes.repositories;

public abstract class CrudRepository<T> {

	protected Connection connection = repositories.util.DBConnection.getConnection();

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
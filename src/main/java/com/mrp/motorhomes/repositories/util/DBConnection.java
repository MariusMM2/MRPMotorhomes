package com.mrp.motorhomes.repositories.util;

public class DBConnection {

	private static final String USERNAME = REDACTED;
	private static final String PASSWORD = REDACTED;
	private static final String CONNSTRING = REDACTED;

	/**
	 * try{
	 *         return DriverManager.getConnection(CONNSTRING, USERNAME, PASSWORD);
	 * }
	 *         catch (SQLException e){
	 *         e.printStackTrace();
	 *         return null;
	 * }
	 */
	public static Connection getConnection() {
		// TODO - implement DBConnection.getConnection
		throw new UnsupportedOperationException();
	}

}
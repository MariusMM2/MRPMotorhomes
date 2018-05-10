package com.mrp.motorhomes.repositories.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String USERNAME = "motorhomedb";
	private static final String PASSWORD = "Yg34cZ1W0~0~";
	private static final String CONNSTRING = "jdbc:mysql://den1.mysql4.gear.host/motorhomedb?useSSL=false";

	/**
	 *
	 */
	public static Connection getConnection() {
		try{
	         return DriverManager.getConnection(CONNSTRING, USERNAME, PASSWORD);
		}
	         catch (SQLException e){
	         e.printStackTrace();
	         return null;
	 	}
	}

}
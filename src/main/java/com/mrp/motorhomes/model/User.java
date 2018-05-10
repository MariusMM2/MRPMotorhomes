package com.mrp.motorhomes.model;

public class User {

	public static final User[] ALL_USERS = {new User("Dave", "salesAssistant"), new User("Ionel", "mechanic"), new User("Jones", "bookkeeper")};
	private String name;
	private String type;
	
	private User(String name, String type){
		this.name = name;
		this.type = type;
	}
}
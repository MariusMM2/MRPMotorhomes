package com.mrp.motorhomes.model;

public class User {
	
	public static final String[] TYPES = {"salesAssistant", "mechanic", "bookkeeper"};
	public static final User[] ALL_USERS = {
			new User("Dave", TYPES[0]),
			new User("Ionel", TYPES[1]),
			new User("Jones", TYPES[2])
	};
	private String name;
	private String type;
	
	private User(String name, String type){
		this.name = name;
		this.type = type;
	}
}
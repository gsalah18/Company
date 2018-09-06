package models;

import java.util.List;

public class User {
	
	private static User instance = new User();
	
	private int id;
	private String name;
	private String password;
	private String type;

	
	public static User getInstance() {
		return instance;
	}
	
	public User() {
		id=0;
		name="";
		password="";
		type="";
	}

	public User(int id, String name, String password, String type) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

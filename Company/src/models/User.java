package models;

import java.util.List;

import utils.DatabaseUtil;

public class User {
	private int id;
	private String name;
	private String password;
	private String type;

	private static DatabaseUtil databaseUtil = new DatabaseUtil();

	public User() {

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

	public static String getUserType(int id, String password) {
		return databaseUtil.getUserType(id, password);
	}

	public static List<User> getUsersforUser(int user_id) {

		return databaseUtil.getUsers(user_id);
	}

	public static boolean addTeamLeader(User teamLeader, int manager_id) {
		return databaseUtil.insertTeamLeader(teamLeader, manager_id);
	}

	public static boolean addDeveloper(User developer, int teamLeaderId) {
		return databaseUtil.insertDeveloper(developer, teamLeaderId);
	}
}

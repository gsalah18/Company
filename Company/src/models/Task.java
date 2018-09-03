package models;

import java.util.Date;
import java.util.List;

import utils.DatabaseUtil;

public class Task {
	private int id;
	private String desc;
	private Date deadline;
	private String state;

	private static DatabaseUtil databaseUtil=new DatabaseUtil();
	
	public Task(int id, String desc, Date deadline, String state) {
		this.id = id;
		this.desc = desc;
		this.deadline = deadline;
		this.state = state;
	}

	
	public Task(String desc, Date deadline, String state) {
		super();
		this.desc = desc;
		this.deadline = deadline;
		this.state = state;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getState() {
		return state;
	} void setState(String state) {
		this.state = state;
	} 
	
	public static List<Task>getTasks(int userId){
		return databaseUtil.getUserTasks(userId);
	}
	
	
}

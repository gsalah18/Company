package models;

import java.util.Date;


public class Task {
	
	private static Task instance=new Task(); 
	
	private int id;
	private String name;
	private String desc;
	private Date deadline;
	private String state;

	public static Task getInstance() {
		return instance;
	}
	
	
	public Task() {
		id=0;
		name="";
		desc="";
		deadline=new Date();
		state="";
	}
	
	public Task(int id,String name, String desc, Date deadline, String state) {
		this.id = id;
		this.name=name;
		this.desc = desc;
		this.deadline = deadline;
		this.state = state;
	}

	
	public Task(String name,String desc, Date deadline) {
		this.name=name;
		this.desc = desc;
		this.deadline = deadline;
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
	} 
	
	void setState(String state) {
		this.state = state;
	} 
	
	
}

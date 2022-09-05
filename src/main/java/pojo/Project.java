package pojo;

import java.util.Date;

public class Project {
	private int id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private String userCodeCreate;
	private String progess;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getUserCodeCreate() {
		return userCodeCreate;
	}
	public void setUserCodeCreate(String userCodeCreate) {
		this.userCodeCreate = userCodeCreate;
	}
	public String getProgess() {
		return progess;
	}
	public void setProgess(String progess) {
		this.progess = progess;
	}
	
	
	
}

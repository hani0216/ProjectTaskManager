package entities;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Task implements Serializable{
	private String code;
	private String description;
	private String projectName;
	private Date startDate;
	private Date endDate;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Task(String code, String description, Date startAt, Date endAt) {
		this.code = code;
		this.description = description;
		this.startDate = startAt;
		this.endDate = endAt;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date date) {
		this.startDate = date;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date date) {
		this.endDate = date;
	}
	
	@Override
	public String toString() {
		return "Task [id=" + code + ", description=" + description + ", start at =" + startDate.toString() + ", end at=" + endDate.toString() + "]";
	}
	
	
}
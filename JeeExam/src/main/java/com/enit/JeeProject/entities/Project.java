package entities;

import java.io.Serializable;
import java.sql.Date;
import dao.*;

@SuppressWarnings("serial")
public class Project implements Serializable{
	private ITaskDao metier;
	private String code;
	private String description;
	private Date startDate;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Project(String code, String description, Date startAt) {
		this.code = code;
		this.description = description;
		this.startDate = startAt;
		this.metier = new TaskDaoImp();
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
	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date date) {
		this.startDate = date;
	}
	
	public void AddTaskToProject(Task task) {
		this.metier.updateTaskProject(task, this.code);
	}
	
	public void removeTaskFromProject(Task task) {
		this.metier.updateTaskProject(task, null);
	}
}
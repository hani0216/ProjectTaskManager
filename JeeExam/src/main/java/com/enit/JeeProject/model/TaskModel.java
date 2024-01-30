package web;

import java.util.*;

import entities.Task;

public class TaskModel {
	
	private List<Task> tasks = new ArrayList<Task>();
	
	public TaskModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import entities.Project;
import entities.Task;

public class TaskDaoImp implements ITaskDao{
	
	private Connection con = SingletonConnection.getConn();
	
	@Override
	public Task AddTask (Task task) {
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO tasks (code, description, start_date, end_date) VALUES (?,?,?,?)");
			ps.setString(1, task.getCode());
			ps.setString(2, task.getDescription());
			ps.setDate(3, task.getStartDate());
			ps.setDate(4, task.getEndDate());	
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;
	}
	
	@Override
	public List<Task> GetAllTasks() {
		List<Task> tasks = new ArrayList<Task>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT code, description, end_date, project_code, start_date FROM tasks");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Task task = new Task();
				task.setCode(rs.getString("code"));
				task.setDescription(rs.getString("description"));
				task.setEndDate(rs.getDate("end_date"));
				task.setStartDate(rs.getDate("start_date"));
				task.setProjectName(rs.getString("project_code"));
				tasks.add(task);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tasks;
	}
	
	@Override
	public Task getTaskByCode(String code) {
		Task task = new Task();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT code, description, start_date, end_date FROM tasks WHERE code = ?");
			System.out.print(code);
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				task.setCode(rs.getString("code"));
				task.setDescription(rs.getString("description"));
				task.setStartDate(rs.getDate("start_date"));
				task.setEndDate(rs.getDate("end_date"));
			}
			ps.close();	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;	
	}
	
	@Override
	public void updateTask(Task task) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE tasks SET description = ?, start_date = ?, end_date = ? WHERE code = ?");
			ps.setString(1, task.getDescription());
			ps.setDate(2, task.getStartDate());
			ps.setDate(3, task.getEndDate());
			ps.setString(4, task.getCode());
			ps.executeUpdate();
			ps.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void DeleteTask(String code) {
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM tasks WHERE code = ?");
			ps.setString(1, code);
			ps.executeUpdate();
			ps.close();	
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	@Override
	public void updateTaskProject(Task task, String pCode) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE tasks SET project_code = ?  WHERE code = ?");
			System.out.println(pCode);
			System.out.println(task.getCode());
			ps.setString(1, pCode);
			ps.setString(2, task.getCode());
			ps.executeUpdate();
			ps.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
}
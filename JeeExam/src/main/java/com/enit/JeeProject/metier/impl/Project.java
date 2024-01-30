package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Date;

import entities.Project;

public class ProjectDaoImp implements IProjectDao{
	
	private Connection con = SingletonConnection.getConn();
	
	@Override
	public Project AddProject (Project project) {
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO projects (code, description, start_date) VALUES (?,?,?);");
			System.out.println("Debug code ...");
			System.out.println(project.getCode());
			System.out.println("End Debugging");
			ps.setString(1, project.getCode());
			ps.setString(2, project.getDescription());
			ps.setDate(3, project.getStartDate());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.print("Error");
			e.printStackTrace();
		}
		return project;
	}
	
	@Override
	public List<Project> GetAllProjects() {
		
		List<Project> projects = new ArrayList<Project>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT code, description, start_date FROM projects");
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				Project project = new Project();
				project.setCode(rs.getString("code"));
				project.setDescription(rs.getString("description"));
				project.setStartDate(rs.getDate("start_date"));
				projects.add(project);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return projects;
	}
	
	@Override
	public Project getProjectByCode(String code) {
		Project project = new Project();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT code, description, start_date FROM projects WHERE code = ?");
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				project.setCode(rs.getString("code"));
				project.setDescription(rs.getString("description"));
				project.setStartDate(rs.getDate("start_date"));
			}
			ps.close();	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}

	@Override
	public void updateProject(Project project) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE projects SET description = ?, start_date = ? WHERE code = ?");
			ps.setString(1, project.getDescription());
			ps.setDate(2, project.getStartDate());
			ps.setString(3, project.getCode());
			ps.executeUpdate();
			ps.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteProject (String code) {
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM projects WHERE code = ?");
			ps.setString(1, code);
			ps.executeUpdate();
			ps.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
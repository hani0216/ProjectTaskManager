package dao;
import java.util.*;
import entities.*;

public interface IProjectDao {
	public Project AddProject(Project project);
	public List<Project> GetAllProjects();
	public void deleteProject(String code);
	public Project getProjectByCode(String code);
	public void updateProject(Project project);
	//public void addTaskToProject(Task task);
	//public void removeTaskFromProject(Task task);
}	
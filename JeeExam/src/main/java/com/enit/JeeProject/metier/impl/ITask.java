package dao;
import java.util.*;
import entities.Task;

public interface ITaskDao {
	public Task AddTask(Task task);
	public List<Task> GetAllTasks();
	public void updateTask(Task task);
	public void DeleteTask(String code);
	public Task getTaskByCode(String code);
	public void updateTaskProject(Task task, String projectCode);
}
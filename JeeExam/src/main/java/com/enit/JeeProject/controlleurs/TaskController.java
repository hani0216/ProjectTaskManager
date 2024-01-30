package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import dao.*;
import entities.*;
import entities.Task;
import java.util.*;

/**
 * Servlet implementation class TaskServlet
 */

@WebServlet({"/task","/task-delete", "/task-edit"})
public class TaskController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ITaskDao metier;
	private IProjectDao metierProject;
	@Override
	public void init() throws ServletException {
		metier = new TaskDaoImp();
		metierProject = new ProjectDaoImp();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path  = request.getServletPath();
		System.out.print(path);
		
		switch (path) {
		case "/task":
			String code = request.getParameter("code");
			String description = request.getParameter("description");
			String endDate = request.getParameter("end_date");
			String startDate = request.getParameter("start_date");
			String project_code = request.getParameter("project_code");
			if (code == null) {
				TaskModel model = new TaskModel();
				List<Task> tasks = metier.GetAllTasks();
				model.setTasks(tasks);
				request.setAttribute("model", model.getTasks());
				request.setAttribute("projects", metierProject.GetAllProjects());
				request.getRequestDispatcher("ListTasks.jsp").forward(request, response);
			} else {
				try {
					Task task =  new Task();
					task.setCode(code);
					task.setDescription(description);
					task.setEndDate(Date.valueOf(endDate));
					task.setStartDate(Date.valueOf(startDate));
					metier.AddTask(task);
					Project project = new Project(project_code,null,null);
					project.AddTaskToProject(task);
					request.getRequestDispatcher("successInsertTask.jsp").forward(request, response);
				} catch (Exception e){
					request.getRequestDispatcher("failedInsertTask.jsp").forward(request, response);
				}
			}
			break;
		case ("/task-delete"):
			String taskCode = request.getParameter("code");
			metier.DeleteTask(taskCode);
			try {
				request.getRequestDispatcher("successRemoveTask.jsp").forward(request, response);
			} catch (Exception e){
				request.getRequestDispatcher("failedRemoveTask.jsp").forward(request, response);
			}
			
			
		case ("/task-edit"):
			String codeToEdit = request.getParameter("code");
			Task task = metier.getTaskByCode(codeToEdit);
			System.out.print(task);
			request.setAttribute("task",task);
			request.getRequestDispatcher("editTask.jsp").forward(request, response);
		default:
			response.setContentType("text/html");
	        PrintWriter printWriter = response.getWriter();
	        printWriter.print("<html>");
	        printWriter.print("<body>");
	        printWriter.print("<h1>Hello World HttpServlet Class Example</h1>");
	        printWriter.print("<a href=\"http://www.javaguides.net\">Java Guides</a>");
	        printWriter.print("</body>");
	        printWriter.print("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String code = request.getParameter("code");
			String description = request.getParameter("description");
			Date startDate = Date.valueOf(request.getParameter("start_date"));
			Date endDate = Date.valueOf(request.getParameter("end_date"));
			Task taskToEdit = new Task(code,description,startDate, endDate);
			
			metier.updateTask(taskToEdit);
			request.getRequestDispatcher("successUpdateTask.jsp").forward(request, response);
		} catch (Exception e){
			request.getRequestDispatcher("failedUpdateTask.jsp").forward(request, response);
		}

	}

}

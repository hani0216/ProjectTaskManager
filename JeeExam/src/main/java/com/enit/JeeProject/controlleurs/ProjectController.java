package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import entities.Project;
import java.sql.Date;
import dao.*;

@WebServlet({"/project","/project-delete", "/project-edit", "/project-create"})
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IProjectDao metier;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    @Override
	public void init() throws ServletException {
		metier = new ProjectDaoImp();
	}
    public ProjectController() {
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
			case ("/project"):
				List<Project> projects = metier.GetAllProjects();
				request.setAttribute("model", projects);
				request.getRequestDispatcher("ListProjects.jsp").forward(request, response);
		
			case ("/project-create"):
					String pCode = request.getParameter("identifiant") ;
					String description = request.getParameter("description");
					String date = request.getParameter("date");
		
					Project project = new Project();
					project.setCode(pCode);
					project.setDescription(description);
					project.setStartDate(Date.valueOf(date));

					Project p = metier.AddProject(project);					
					request.getRequestDispatcher("successInsertProject.jsp").forward(request, response);
		
			case ("/project-delete"):
				try {
					String projectCode = request.getParameter("code");
					metier.deleteProject(projectCode);
					request.getRequestDispatcher("successRemoveProject.jsp").forward(request, response);
				} catch (Exception e){
					request.getRequestDispatcher("failedRemoveProject.jsp").forward(request, response);
				}				
			case ("/project-edit"):
				String codeToEdit = request.getParameter("code");
				Project projectToEdit = metier.getProjectByCode(codeToEdit);
				request.setAttribute("project",projectToEdit);
				request.getRequestDispatcher("editProject.jsp").forward(request, response);
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
			Date startDate = Date.valueOf(request.getParameter("date"));
			Project projectToEdit = new Project(code,description,startDate);
			metier.updateProject(projectToEdit);
			request.getRequestDispatcher("successUpdateProject.jsp").forward(request, response);
			
		} catch (Exception e){
			request.getRequestDispatcher("failedUpdateProject.jsp").forward(request, response);
		}
	}

}

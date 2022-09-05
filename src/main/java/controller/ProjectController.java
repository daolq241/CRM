package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProjectModel;
import pojo.Project;

@WebServlet("/project")
public class ProjectController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProjectModel model = new ProjectModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Project> projects =new ArrayList<>();
		projects = model.getAllProject();
		System.out.println(projects);
		req.setAttribute("projects", projects);
		req.getRequestDispatcher("project.jsp").forward(req, resp);
	}

}

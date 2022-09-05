package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaskModel;
import model.UserTaskModel;

@WebServlet("/deleteTask")
public class DeleteTaskController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TaskModel taskModel = new TaskModel();
	UserTaskModel userTaskModel = new UserTaskModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		int taskId = Integer.parseInt(req.getParameter("id"));
		
		userTaskModel.deleteUserTask(taskId);
		taskModel.deleteTask(taskId);
		
		resp.sendRedirect(req.getContextPath() + "/task");
	}
}

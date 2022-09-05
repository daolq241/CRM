package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TaskModel;
import pojo.Task;

@WebServlet("/task")
public class TaskController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TaskModel taskModel = new TaskModel();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Task> tasks = taskModel.getAllTask();
		System.out.println(tasks);
		req.setAttribute("tasks", tasks);
		req.getRequestDispatcher("task.jsp").forward(req, resp);
	}
}

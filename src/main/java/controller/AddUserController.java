package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.UserModel;
import pojo.User;

@WebServlet("/addUser")
public class AddUserController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserModel userModel = new UserModel();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setCode(req.getParameter("code"));
		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setAddress(req.getParameter("address"));
		user.setRoleId(Integer.parseInt(req.getParameter("role_id")));
		
		Boolean result = userModel.addUser(user);
		String message = "";
		if(result) {
			message = "Sussess";
		} else  {
			message = "Fail";
		}
		
//		Gson gson = new Gson();
//		String jsonData = gson.toJson(message);
//		PrintWriter writer = resp.getWriter();
//		writer.write(jsonData);
//		writer.flush();
//		writer.close();
		
		
		System.out.println(message);
		req.setAttribute("message", message);

		req.getRequestDispatcher("user-add.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/user-add.jsp").forward(req, resp);
	}
}

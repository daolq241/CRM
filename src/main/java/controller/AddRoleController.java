package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RoleModel;
import pojo.Role;

@WebServlet("/addRole")
public class AddRoleController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RoleModel model = new RoleModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Role role = new Role();
		role.setName(req.getParameter("name"));
		role.setName(req.getParameter("description"));
		model.addRole(role);
		
		req.getRequestDispatcher("role-add.jsp").forward(req, resp);
	}
}

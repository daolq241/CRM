package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RoleModel;
import model.UserModel;
import pojo.Role;

@WebServlet("/role")
public class RoleController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RoleModel model = new RoleModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Role> roles = model.getAllRole();
		System.out.println(roles);
		req.setAttribute("roles", roles);
		req.getRequestDispatcher("role.jsp").forward(req, resp);
	}

}

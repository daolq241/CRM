package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RoleModel;
import model.UserModel;

@WebServlet("/deleteRole")
public class DeleteRoleController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	RoleModel roleModel = new RoleModel();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		int roleId = Integer.parseInt(req.getParameter("id"));
		roleModel.deleteRole(roleId);
		resp.sendRedirect(req.getContextPath() + "/role");
//		req.getRequestDispatcher("role.jsp").forward(req, resp);
	}
	

}

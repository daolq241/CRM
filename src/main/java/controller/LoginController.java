package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Constant;
import common.CookieFilter;
import model.UserModel;
import pojo.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	UserModel userModel = new UserModel();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = userModel.checkLogin(email, password);
		
		if (user!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("SESSION_USER", user);
			session.setMaxInactiveInterval(10000);
			resp.sendRedirect(req.getContextPath()+"/home");
			
		} else {
			System.out.println("Login fail");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

	}
}

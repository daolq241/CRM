package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		if (user != null) {
			Cookie cookie = new Cookie(CookieFilter.COOKIES_USER, user.getName());
			cookie.setMaxAge(600);
			resp.addCookie(cookie);
			resp.sendRedirect(req.getContextPath() + Constant.HOME);
		} else {
			resp.sendRedirect(req.getContextPath() + Constant.ERROR);
		}

	}
}

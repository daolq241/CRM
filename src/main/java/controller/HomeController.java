package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
	
		System.out.println(sess);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
//		resp.setContentType("text/html; charset=UTF-8");
//		resp.setCharacterEncoding("UTF-8");
	}
}

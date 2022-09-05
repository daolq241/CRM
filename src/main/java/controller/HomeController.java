package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String contextPath = req.getContextPath();
		System.out.println(contextPath);
		System.out.println(req.getServletPath());
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
//		resp.setContentType("text/html; charset=UTF-8");
//		resp.setCharacterEncoding("UTF-8");
	}
}

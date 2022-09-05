package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.UserModel;
import pojo.User;

@WebServlet("/api/user")
public class APIUserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserModel model = new UserModel();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = model.getAllUser();
		
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(users);
		PrintWriter writer = resp.getWriter();
		writer.write(jsonData);
		
		writer.flush();
		writer.close();
		
	}
}

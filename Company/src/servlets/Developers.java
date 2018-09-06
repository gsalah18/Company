package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DatabaseUtil;

public class Developers extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id = req.getParameter("user_id");
		List<User>developers=DatabaseUtil.getInstance().getUsersForManager(user_id);
		
		req.setAttribute("developers", developers);
		System.out.println("I'm in Developer Servlet");
		//resp.sendRedirect("views/developers.jsp");
		req.getRequestDispatcher("views/developers.jsp").forward(req, resp);
	}

	
}

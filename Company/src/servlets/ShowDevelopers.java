package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

public class ShowDevelopers extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		List<User>developers=User.getUsersforUser(user_id);
		
		req.setAttribute("developers", developers);
		req.getRequestDispatcher("views/showDevelopers.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		List<User>developers=User.getUsersforUser(user_id);
		
		req.setAttribute("developers", developers);
		req.getRequestDispatcher("views/showDevelopers.jsp").forward(req, resp);
	}
	
}

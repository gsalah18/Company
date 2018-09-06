package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DatabaseUtil;

public class AddUser extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String type = req.getParameter("type");
		String teamLeader = req.getParameter("manager");
		
		if(req.getSession().getAttribute("userId") == null
				|| req.getSession().getAttribute("userType") == null 
				|| (name == null || name.length() == 0)
				|| (password == null || password.length() == 0)
				|| (type == null || type.length() == 0)
				|| (teamLeader == null || teamLeader.length() == 0)) {
			resp.sendRedirect("index");
			return;
		}
		
		
		
		User user = new User(name,password);
		user.setType(type);
		DatabaseUtil.getInstance().insertUser(user, teamLeader);
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("success");
	}

	
}

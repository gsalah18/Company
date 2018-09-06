package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import models.User;
import utils.DatabaseUtil;

public class Home extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("userId") == null
				|| req.getSession().getAttribute("userType") == null) {
			resp.sendRedirect("index");
			return;
		}
		
		String userId = req.getSession().getAttribute("userId").toString();
		String userType = req.getSession().getAttribute("userType").toString();
		String url = "";
		List<User> users = null;
		List<Task>tasks = null;
		
		if (userType.equals("Manager")) {
			users = DatabaseUtil.getInstance().getUsersForManager(userId);
			req.setAttribute("teamLeaders", users);
			url="views/manager/home.jsp";
		} else if (userType.equals("Team Leader")) {
			users = DatabaseUtil.getInstance().getUsersForManager(userId);
			tasks = DatabaseUtil.getInstance().getUserTasks(userId);
			req.setAttribute("developers", users);
			req.setAttribute("tasks", tasks);
			url="views/teamleader/home.jsp";
		} else {
			tasks = DatabaseUtil.getInstance().getUserTasks(userId);
			String teamLeader = DatabaseUtil.getInstance().getUserTeamLeader(userId);
			req.setAttribute("tasks", tasks);
			req.setAttribute("teamLeader", teamLeader);
			url="views/developer/home.jsp";
		}
		
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher(url);
		requestDispatcher.forward(req, resp);
		
	}

	

	
}

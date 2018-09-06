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
		String userId = req.getSession().getAttribute("userId").toString();
		String userType = req.getSession().getAttribute("userType").toString();
		String url="";
		
		if(userType.equals("Manager")) {
			List<User> teamLeaders=DatabaseUtil.getInstance().getUsersForManager(userId);
			req.setAttribute("teamLeaders", teamLeaders);
			url="views/manager/home.jsp";
		}else if(userType.equals("Team Leader")) {
			List<User>developers = DatabaseUtil.getInstance().getUsersForManager(userId);
			List<Task>tasks=DatabaseUtil.getInstance().getUserTasks(userId);
			req.setAttribute("developers", developers);
			req.setAttribute("tasks", tasks);
			url="views/teamleader/home.jsp";
		}else {
			List<Task>tasks=DatabaseUtil.getInstance().getUserTasks(userId);
			String teamLeader=DatabaseUtil.getInstance().getUserTeamLeader(userId);
			req.setAttribute("tasks", tasks);
			req.setAttribute("teamLeader", teamLeader);
			url="views/developer/home.jsp";
		}
		
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher(url);
		requestDispatcher.forward(req, resp);
	}

	

	
}

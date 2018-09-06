package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DatabaseUtil;

public class Tasks extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("user_id");
		String userType = req.getParameter("user_type");
		List<Task>tasks=DatabaseUtil.getInstance().getUserTasks(userId);
		req.setAttribute("userType", userType);
		req.setAttribute("userId", userId);
		req.setAttribute("tasks", tasks);
		req.getRequestDispatcher("views/tasks.jsp").forward(req, resp);
	}
	
	
}

package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;

public class ShowTasks extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("user_id"));
		List<Task>tasks=Task.getTasks(userId);
		
		req.setAttribute("tasks", tasks);
		req.getRequestDispatcher("views/showTasks.jsp").forward(req, resp);
	}
	
	
}

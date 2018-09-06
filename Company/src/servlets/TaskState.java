package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DatabaseUtil;

public class TaskState extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String taskId=req.getParameter("taskId");
		int state=Integer.parseInt(req.getParameter("state"));
		DatabaseUtil.getInstance().changeTaskState(taskId, state);
		resp.setContentType("text/plain");
		resp.getWriter().write("changed");
	}
	
}

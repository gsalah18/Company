package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DatabaseUtil;

public class TaskState extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String taskId = req.getParameter("taskId");
		String stateStr = req.getParameter("state");
		if(req.getSession().getAttribute("userId") == null
				|| req.getSession().getAttribute("userType") == null
				|| (taskId == null || taskId.length() == 0)
				|| (stateStr == null || stateStr.length() == 0)) {
			resp.sendRedirect("index");
			return;
		}
		
		int state = Integer.parseInt(stateStr);
		DatabaseUtil.getInstance().changeTaskState(taskId, state);
		resp.setContentType("text/plain");
		resp.getWriter().write("changed");
	}
	
}

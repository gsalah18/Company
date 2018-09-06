package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DatabaseUtil;

public class AssignTask extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String taskId = req.getParameter("taskId");
		String receiverId = req.getParameter("receiverId");
		
		if(req.getSession().getAttribute("userId") == null
				|| req.getSession().getAttribute("userType") == null
				|| (taskId == null || taskId.length() == 0)
				|| (receiverId == null || receiverId.length() == 0)) {
			resp.sendRedirect("index");
			return;
		}
		
		//TODO Add the task to the Receiver and Delete it from the Owner.
		
		DatabaseUtil.getInstance().assignTask(taskId, receiverId);
		
		resp.setContentType("text/plain");
		resp.getWriter().write("success");
	}

	
	
}

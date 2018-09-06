package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.Commons;
import utils.DatabaseUtil;

public class AddTask extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId= req.getParameter("userId");
		String name =req.getParameter("name");
		String desc = req.getParameter("desc");
		Date deadline;
		
		try {
			deadline = Commons.simpleDateFormat.parse(req.getParameter("deadline"));
			Task task = new Task(name, desc, deadline);
			DatabaseUtil.getInstance().insertTask(task, userId);
			
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write("sucess");
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}

}

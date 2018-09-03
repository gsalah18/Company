package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		request=req;
		response=resp;
		try {
		int id=Integer.parseInt(req.getParameter("userId"));
		requiredValidation(id+"", "Id");
		String password=req.getParameter("password");
		requiredValidation(password, "Password");
		String userType =User.getUserType(id, password);
		resp.getWriter().println(userType);
			if(userType==null)
				sendErrorMSG(getServletContext().getInitParameter("server_msg"));
			else if(userType.length()==0)
				sendErrorMSG("Wrong Id or Password");
			else {
				request.getSession().setAttribute("error", "");
				request.getSession().setAttribute("userId", id);
				if(userType.equalsIgnoreCase("Manager")) {
					response.sendRedirect("managerHome");
				}
				else if(userType.equalsIgnoreCase("Team Leader"))
					;
				else if(userType.equalsIgnoreCase("Developer"));
			}
		}catch (NumberFormatException e) {
			sendErrorMSG("Invalid Id (must be a Number)");
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	private void sendErrorMSG(String msg) {
			try {
				request.getSession().setAttribute("error", msg);
				response.sendRedirect("index");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void requiredValidation(String str,String fieldName) {
		if(str.length()==0) {
			sendErrorMSG(fieldName+" is Required");
		}
	}

	
	
}

package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie userId=new Cookie("userId", "");
		userId.setMaxAge(0);
		resp.addCookie(userId);

		Cookie userType=new Cookie("userType", "");
		userType.setMaxAge(0);
		resp.addCookie(userType);

		req.getSession().invalidate();
		
		resp.sendRedirect("index");
	}

}

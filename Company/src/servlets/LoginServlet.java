package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DatabaseUtil;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		request = req;
		response = resp;
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if((username == null || username.length() == 0)
				|| (username == null || username.length() == 0)) {
			resp.sendRedirect("index");
			return;
		}
		
		
		if (requiredValidation(username, "username")
				&& requiredValidation(password, "Password")) {
				

				String userType = DatabaseUtil.getInstance().getUserType(username, password);

				if (checkError(userType)) {
					String userId = DatabaseUtil.getInstance().getUserId(username);
					setCookie(userId, userType);
					request.getSession().setAttribute("userId", userId);
					request.getSession().setAttribute("userType", userType);
					sendResponseMSG("home");
				}
		}
	}
	
	void setCookie(String userId, String userType) {
		int year = 60 * 60 * 24 * 365;
		Cookie idCookie = new Cookie("userId", userId);
		idCookie.setMaxAge(year);
		response.addCookie(idCookie);

		Cookie typeCookie = new Cookie("userType", userType);
		typeCookie.setMaxAge(year);
		response.addCookie(typeCookie);

	}

	private boolean checkError(String userType) {
		String msg = "";
		if (userType.contains("Server error")) {
			msg = getServletContext().getInitParameter("server_msg");
			sendResponseMSG(msg);
			return false;
		} else if (userType.length() == 0) {
			msg = "Wrong Username or Password";
			sendResponseMSG(msg);
			return false;
		}
		return true;

	}

	private boolean requiredValidation(String str, String fieldName) {
		if (str.length() == 0) {
			sendResponseMSG(fieldName + " is Required");
			return false;
		}
		return true;
	}

	private void sendResponseMSG(String msg) {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			System.out.println("Exception from SendResponse Method: "+e.getMessage());
		}
	}

}

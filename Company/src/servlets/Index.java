package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		request = req;

		if (checkValueExistsInCookies("userId") && checkValueExistsInCookies("userType")) {
			String userType = getCookieValue("userType");
			HttpSession session = req.getSession();
			session.setAttribute("userId", getCookieValue("userId"));
			session.setAttribute("userType", userType);

			if (userType.equals("Manager")) {
				resp.sendRedirect("managerhome");
			} else if (userType.equals("Team Leader")) {
				resp.sendRedirect("teamleaderhome");
			} else {
				resp.sendRedirect("developerhome");
			}
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

	private boolean checkValueExistsInCookies(String key) {
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals(key))
					return true;
			}
		}
		return false;
	}

	private String getCookieValue(String key) {
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals(key))
				return cookie.getValue();
		}
		return "";
	}

}

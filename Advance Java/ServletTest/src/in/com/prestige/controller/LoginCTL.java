package in.com.prestige.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.soap.InitParam;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCTL
 */
@WebServlet(urlPatterns = "/LoginCTL", initParams = { @WebInitParam(name = "username", value = "Deependra"),
		@WebInitParam(name = "Email", value = "c.deependra471") })
public class LoginCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		log("User : " + user + " Email:" + pass);
		if (getServletConfig().getInitParameter("username").equals(user)
				&& getServletConfig().getInitParameter("Email").equals(pass)) {
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/LoginSuccess.jsp");
			Cookie c = new Cookie("UserName", user);
			Cookie c2 = new Cookie("Email", pass);
			c2.setMaxAge(60 * 60);
			response.addCookie(c);
			response.addCookie(c2);
			rd.include(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/Login.jsp");
			PrintWriter out = response.getWriter();
			out.println("<font color =red>Either UserName or Password Is wrong</font>");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

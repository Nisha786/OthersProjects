package in.com.prestige.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(urlPatterns="/Hello",loadOnStartup=1)//Tomcat 7 and above support 3.0 API
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();
	        pw.println("<HTML><BODY>");
	        pw.println("<H1>Hello Servlet</H1>");
	        pw.println("</BODY></HTML>");
	        pw.close();	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

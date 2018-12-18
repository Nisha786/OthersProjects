package in.com.prestige.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpRequsetsObject
 */
@WebServlet("/HttpRequsetsObject")
public class HttpRequsetsObject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            PrintWriter pw = response.getWriter();
            response.setIntHeader("Refresh", 5);
            response.setContentType("text/html");
            pw.println("<Html><body>");
            pw.println("<div>");
            pw.println("Name : "+request.getParameter("name"));
            pw.println("Email : "+request.getParameter("email"));
            pw.println("Password : "+request.getParameter("password"));
            pw.println("</div>");
            pw.println("</Html></body>");
            Enumeration e = request.getHeaderNames();
            while(e.hasMoreElements()){
            	String name = (String)e.nextElement();
            	String values = request.getHeader(name);
            	System.out.println(name+ "---" + values);
            }
            pw.println(request.getCookies());
            pw.println(request.getRemoteHost());
            pw.println(request.getRemotePort());
            pw.println(request.getServerPort());
            pw.println(request.getServletPath());
            pw.print(request.getContextPath());
            
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

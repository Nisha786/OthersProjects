package in.com.prestige.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DashboardCtl
 */
@WebServlet("/DashboardCtl")
public class DashboardCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		
		if(email.equals("deependra471@gmail.com") && pass.equals("9685566182")){
			HttpSession session = request.getSession();
			   session.setAttribute("adminLogin", email);
	            response.sendRedirect("dashboard.jsp");
		}else{
			String message = "User Id or PassWord is Invalid";
			request.getSession().setAttribute("message", message);
			response.sendRedirect("admin.jsp");
			//pw.println("User Id or PassWord is Invalid");
			///RequestDispatcher rs = request.getRequestDispatcher("/admin.jsp");
			//rs.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

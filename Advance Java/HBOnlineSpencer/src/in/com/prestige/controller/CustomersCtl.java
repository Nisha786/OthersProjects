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

import in.com.prestige.dto.CustomerDTO;
import in.com.prestige.model.CustomerModel;
import in.com.prestige.utility.JavaMailUtility;

/**
 * Servlet implementation class CustomersCtl
 */
@WebServlet("/CustomersCtl")
public class CustomersCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
		    PrintWriter pw = response.getWriter();
		    try{
		    	CustomerDTO bean = new CustomerDTO();
		    	CustomerModel model = new CustomerModel();
		    	
		    	bean.setName(request.getParameter("cname"));
		    	bean.setEmail(request.getParameter("cemail"));
		    	bean.setPassword(request.getParameter("cpwd"));
		    	bean.setContactno(request.getParameter("contact"));
		    	int res = model.addCustomers(bean);
		    	if(res>=1){
		    		JavaMailUtility.sendEmail(request.getParameter("cemail"), request.getParameter("cpwd"),request.getParameter("contact"));
		    		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
		    		rd.include(request, response);
		    	}else{
		    		
		    		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
		    		rd.include(request, response);
		    	}
		    }catch(Exception e){
		    	
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

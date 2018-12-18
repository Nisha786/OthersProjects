package in.com.prestige.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.prestige.bean.CustomerBean;
import in.com.prestige.model.CustomerModel;
import in.com.prestige.utility.JavaMailUtility;

/**
 * Servlet implementation class CustomersAdminCtl
 */
@WebServlet("/CustomersAdminCtl")
public class CustomersAdminCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersAdminCtl() {
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
	    	CustomerBean bean = new CustomerBean();
	    	CustomerModel model = new CustomerModel();
	    	
	    	bean.setName(request.getParameter("cname"));
	    	bean.setEmail(request.getParameter("cemail"));
	    	bean.setPassword(request.getParameter("cpwd"));
	    	
	    	int res = model.addCustomers(bean);
	    	if(res>=1){
	    		JavaMailUtility.sendEmail(request.getParameter("cemail"), request.getParameter("cpwd"));
	    		pw.println("Succesfully Record Inserted");
	    		RequestDispatcher rd = request.getRequestDispatcher("/CustomersAddView.jsp");
	    		rd.include(request, response);
	    	}else{
	    		pw.println("Record Not Inserted");
	    		RequestDispatcher rd = request.getRequestDispatcher("/CustomersAddView.jsp");
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

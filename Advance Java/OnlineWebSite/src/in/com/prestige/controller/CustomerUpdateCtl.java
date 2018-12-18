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
 * Servlet implementation class CustomerDeleteCtl
 */
@WebServlet("/CustomerUpdateCtl")
public class CustomerUpdateCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateCtl() {
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
		    int cid  = Integer.parseInt(request.getParameter("cid"));
		    String cname  = request.getParameter("cname");
		    String email = request.getParameter("email");
		    String pass = request.getParameter("pass");
		    
		    CustomerBean bean = new CustomerBean();
		    CustomerModel model = new CustomerModel();
		    
		    bean.setName(cname);
		    bean.setEmail(email);
		    bean.setPassword(pass);
		    int res = model.updateUserEntry(cid, bean);
		    if(res>=1){
		    	JavaMailUtility.sendEmail(email, pass);
		    	
                RequestDispatcher rd = request.getRequestDispatcher("/GetCustomersList.jsp");
		        rd.include(request, response);
		     }else{
		    	 
		    	 RequestDispatcher rd = request.getRequestDispatcher("/GetCustomersList.jsp");
			     rd.include(request, response);
		    }
		    
		   
		    
		}catch(Exception e){
			e.printStackTrace();
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

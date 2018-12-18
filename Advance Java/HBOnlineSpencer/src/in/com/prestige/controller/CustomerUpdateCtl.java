package in.com.prestige.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.prestige.dto.CustomerDTO;
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
		    String phone = request.getParameter("contact");
		    
		    CustomerDTO bean = new CustomerDTO();
		    CustomerModel model = new CustomerModel();
		    bean.setCustomersID(cid);
		    bean.setName(cname);
		    bean.setEmail(email);
		    bean.setPassword(pass);
		    bean.setContactno(phone);
		    int res = model.updateUserEntry(bean);
		    if(res>=1){
		    	JavaMailUtility.sendEmail(email,pass,phone);
		    	
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

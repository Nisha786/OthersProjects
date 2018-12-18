package in.com.prestige.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.prestige.bean.CustomerBean;
import in.com.prestige.model.CustomerModel;

/**
 * Servlet implementation class CustomersCtl
 */
@WebServlet("/CustomersCtl")
public class CustomersCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CustomersCtl() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		CustomerBean bean = new CustomerBean();
		CustomerModel model = new CustomerModel();
		
		bean.setFname(request.getParameter("fname"));
		bean.setLname(request.getParameter("fname"));
		bean.setGender(request.getParameter("gender"));
		bean.setContactNumber(Integer.parseInt(request.getParameter("contact")));
		int res = model.addCustomers(bean);
		if(res>=1){
			pw.println("Record Inserted Succesfully");
			pw.println(" <a href='SpencerHome.html'>Home Page</a>");
		}else{
			pw.print("Not Inserted");
			pw.println(" <a href='SpencerHome.html'>Home Page</a>");
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

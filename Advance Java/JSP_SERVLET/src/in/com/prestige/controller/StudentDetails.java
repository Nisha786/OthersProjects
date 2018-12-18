package in.com.prestige.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.prestige.bean.StudentBean;
import in.com.prestige.model.StudentModel;

/**
 * Servlet implementation class StudentDetails
 */
@WebServlet("/StudentDetails")
public class StudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public StudentDetails() {
        super();
       
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    	PrintWriter pw = response.getWriter();
    	String name = request.getParameter("sname");
    	String gender = request.getParameter("gender");
    	String address = request.getParameter("address");
    	int contact = (Integer.parseInt(request.getParameter("contact")));
    	
    	StudentBean bean = new StudentBean();
    	bean.setName(name);
    	bean.setAddress(address);
    	bean.setGender(gender);
    	bean.setContactNo(contact);
    	
    	StudentModel model = new StudentModel();
    	
    	try{
    		int i = model.addStudent(bean);
    		if(i>=1){
        		pw.println("Record Succesfully Inserted : "+i);
        	}else{
        		pw.println("Not Inserted");
        	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

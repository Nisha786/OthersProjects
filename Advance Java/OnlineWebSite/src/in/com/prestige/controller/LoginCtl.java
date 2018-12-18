package in.com.prestige.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.com.prestige.bean.CustomerBean;
import in.com.prestige.model.CustomerModel;

/**
 * Servlet implementation class LoginCtl
 */
@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			CustomerBean bean = new CustomerBean();
			CustomerModel model = new CustomerModel();
			 
			
			//bean.setName(username);
			//bean.setPassword(password);
			ArrayList list = model.checUserLogin(username,password);
			Iterator it  = list.iterator();
			while(it.hasNext()){
				bean = (CustomerBean)it.next();
			}
			//System.out.println(list.toArray().length);
			if(list.toArray().length == 1){
			if(bean.getName().equals(username)  && bean.getPassword().equals(password)){
				HttpSession session = request.getSession();
	    		session.setAttribute("userLoginsession",request.getParameter("username") );
	    		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
	    		rd.forward(request, response);
			}
			}
			else{
				
				RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
	    		rd.forward(request, response);
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

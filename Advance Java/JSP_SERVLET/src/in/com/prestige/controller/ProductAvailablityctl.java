package in.com.prestige.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.prestige.model.ProductModel;

/**
 * Servlet implementation class ProductAvailablityctl
 */
@WebServlet("/ProductAvailablityctl")
public class ProductAvailablityctl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAvailablityctl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		ProductModel model = new ProductModel();
		String pname = request.getParameter("pname");
		try{
			int res = model.checkProductAvail(request.getParameter("pname"));
			if(res >=1){
				pw.println("Number Of Available Product "+pname +" : "+res);
				pw.println(" <a href='SpencerHome.html'>Home Page</a>");
			}else{
				pw.println(pname +  " : NO such a elemnent in store");
				pw.println(" <a href='SpencerHome.html'>Home Page</a>");
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

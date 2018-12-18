package in.com.prestige.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.prestige.bean.ProductsBean;
import in.com.prestige.model.ProductModel;

/**
 * Servlet implementation class ProductCtl
 */
@WebServlet("/ProductCtl")
public class ProductCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProductCtl() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		ProductsBean bean = new ProductsBean();
		ProductModel model = new ProductModel();
		
		bean.setProductName(request.getParameter("pname"));
		bean.setPrice(Double.parseDouble(request.getParameter("price")));
		bean.setStatus(request.getParameter("status"));
		int res = model.addProducts(bean);
		if(res>=1){
			pw.println("Record Insertesd Succesfully");
			pw.println(" <a href='SpencerHome.html'>Home Page</a>");
		}else{
			pw.println("Not Inserted");
			pw.println(" <a href='SpencerHome.html'>Home Page</a>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

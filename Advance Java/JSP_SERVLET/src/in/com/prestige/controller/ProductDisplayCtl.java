package in.com.prestige.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.prestige.bean.ProductsBean;
import in.com.prestige.model.ProductModel;

/**
 * Servlet implementation class ProductDisplayCtl
 */
@WebServlet("/ProductDisplayCtl")
public class ProductDisplayCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDisplayCtl() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		ProductModel model = new ProductModel();
		ProductsBean bean = new ProductsBean();
		try{
			ArrayList list = model.displayProducts();
			Iterator it = list.iterator();
			pw.println("<div align = 'center'>");
			pw.println("<table border = '1'>");
			pw.println("<tr>");
			pw.println("<th align = 'center' colspan = '3'>");
			pw.println("Product List");
			pw.println("</th>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<th>");
			pw.println("Product ID");
			pw.println("</th>");
			pw.println("<th>");
			pw.println("Product Name");
			pw.println("</th>");
			pw.println("<th>");
			pw.println("Product Price");
			pw.println("</th>");
			pw.println("</tr>");
			while(it.hasNext()){
				bean = (ProductsBean)it.next();
				//System.out.println(bean.getPrice()+"----------"+bean.getProductID()+"----"+bean.getProductName());
				pw.println("<tr>");
				pw.println("<td>");
				pw.println(bean.getProductID());
				pw.println("</td>");
				pw.println("<td>");
				pw.println(bean.getProductName());
				pw.println("</td>");
				pw.println("<td>");
				pw.println(bean.getPrice());
				pw.println("</td>");
				pw.println("</tr>");
				
			}
			pw.println(" <a href='SpencerHome.html'>Home Page</a>");
			pw.println("</table>");
			pw.println("</div>");
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

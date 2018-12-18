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
 * Servlet implementation class BookProductsCtl
 */
@WebServlet("/BookProductsCtl")
public class BookProductsCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookProductsCtl() {
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
			ProductModel model = new ProductModel();
			String res = model.bookProdcuts(Integer.parseInt(request.getParameter("cid")),request.getParameter("pname"),Integer.parseInt(request.getParameter("numberofpro")));
			pw.println(res);
			pw.println(" <a href='SpencerHome.html'>Home Page</a>");
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

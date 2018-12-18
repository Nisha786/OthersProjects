package in.com.prestige.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import in.com.prestige.bean.ProductsBean;
import in.com.prestige.model.ProductModel;

/**
 * Servlet implementation class ProductCtl
 */
@WebServlet("/ProductCtl")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class ProductCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("pname");
		String status = request.getParameter("status");
		String category = request.getParameter("category");
		double price = Double.parseDouble(request.getParameter("price"));
		int noOfProducts = Integer.parseInt(request.getParameter("noOfProducts"));
		Part filepart = request.getPart("picimg");
		String fileName = extractFileName(filepart);//file name
		String savePath = "F:\\Prestige Java\\Advance Java\\OnlineWebSite\\WebContent\\images\\" + fileName;
		File fileSaveDir = new File(savePath);
        filepart.write(savePath +File.separator);
		
		
		ProductsBean bean = new ProductsBean();
		ProductModel model = new ProductModel();
		
		bean.setProductName(name.toUpperCase());
		bean.setStatus(status.toUpperCase());
		bean.setCategory(category.toUpperCase());
		bean.setPrice(price);
		bean.setFilename(savePath);
		bean.setPath(savePath);
		bean.setNumberofproducts(noOfProducts);
		int res = model.addProducts(bean);
		if(res>=1){
			pw.println("SuccessFull Inserted");
			RequestDispatcher rd=request.getRequestDispatcher("/ProductAddView.jsp");  
	        rd.include(request, response);
		}else{
			pw.println("Not Inserted");
			RequestDispatcher rd=request.getRequestDispatcher("/ProductAddView.jsp");  
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
	
	
	 // file name of the upload file is included in content-disposition header like this:
    //form-data; name="dataFile"; filename="PHOTO.JPG"
	 private String extractFileName(Part part) {//This method will print the file name.
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length() - 1);
	            }
	        }
	        return "";
	    }

}

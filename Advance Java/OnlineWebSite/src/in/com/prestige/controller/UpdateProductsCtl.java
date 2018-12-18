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

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

import in.com.prestige.bean.ProductsBean;
import in.com.prestige.model.ProductModel;

/**
 * Servlet implementation class UpdateProductsCtl
 */
@WebServlet("/UpdateProductsCtl")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class UpdateProductsCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductsCtl() {
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
			Part filepart = request.getPart("picimg");
			String fileName = extractFileName(filepart);//file name
			String savePath = "F:\\Prestige Java\\Advance Java\\OnlineWebSite\\WebContent\\images\\" + fileName;
			File fileSaveDir = new File(savePath);
	        filepart.write(savePath +File.separator);
	        
			ProductsBean bean = new ProductsBean();
			ProductModel model = new ProductModel();
			
			bean.setCategory(request.getParameter("category"));
			bean.setProductName(request.getParameter("products"));
			bean.setPrice(Double.parseDouble(request.getParameter("price")));
			bean.setNumberofproducts(Integer.parseInt(request.getParameter("numberOfProducts")));
			bean.setFilename(savePath);
			bean.setPath(savePath);
			
			int res = model.updateProducts(bean);
			if(res>=1){
				pw.println("SuccessFull Updated Records");
				RequestDispatcher rd=request.getRequestDispatcher("/UpdateProductsView.jsp");  
		        rd.include(request, response);
			}else{
				pw.println("Not updated Any Records");
				RequestDispatcher rd=request.getRequestDispatcher("/UpdateProductsView.jsp");  
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

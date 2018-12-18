package in.com.prestige.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

import in.com.prestige.bean.ProductsBean;
import in.com.prestige.model.ProductModel;

@WebServlet("/UpdateProductsCtl")

public class UpdateProductsCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateProductsCtl() {
        super();
       
    }
     // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String fileName = null;
	     String filePath= null;
	     String uploadPath= null;
	     response.setContentType("text/html");
	     HashMap map = new HashMap();
	     String key = null;
	     String value = null;
	     PrintWriter writer = response.getWriter();	    // checks if the request actually contains upload file
	        if (!ServletFileUpload.isMultipartContent(request)) {
	            // if not, we stop here
	            writer.println("Error: Form must has enctype=multipart/form-data.");
	            writer.flush();
	            return;
	        }
	        // configures upload settings
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        // sets memory threshold - beyond which files are stored in disk
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        // sets temporary location to store files
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        // sets maximum size of upload file
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	        // sets maximum size of request (include file + form data)
	        upload.setSizeMax(MAX_REQUEST_SIZE);
	        uploadPath= "F://Prestige Java//Advance Java//OnlineSpencer2//WebContent//upload"+ File.separator + UPLOAD_DIRECTORY;
	        // creates the directory if it does not exist
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	        try {
	            // parses the request's content to extract file data
	           java.util.List<FileItem> formItems = upload.parseRequest(request);
	              if (formItems != null && formItems.size() > 0) {
	                // iterates over form's fields
	                for (FileItem item : formItems) {
	                	 // processes only fields that are  form fields
	                	if (item.isFormField()) {
	                	    key = item.getFieldName();
	                	    value = item.getString();
	                	    //System.out.println(key);
	                	    //System.out.println(value);
	                	    map.put(key, value);
	                	  
	                	}
	                    // processes only fields that are not form fields
	                    if (!item.isFormField()) {
	                        fileName = new File(item.getName()).getName();
	                        filePath = uploadPath + File.separator + fileName;
	                        File storeFile = new File(filePath);
	                        // saves the file on disk
	                        item.write(storeFile);
	                      }
	                }
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();;
	        }
		try{
			
			Object[] str = new Object[map.size()];
			   //System.out.println(map.values());
			    str = Arrays.copyOf(map.values().toArray(), map.size());
			   // System.out.println((String)str[0]);
			   // double i = Double.parseDouble((String)str[1]) + 1500;
			   // System.out.println(i);
				String name = (String)str[3];
				//String status = (String)str[4];
				String category = (String)str[2];
				double price = Double.parseDouble((String)str[0]);
				int noOfProducts = Integer.parseInt((String)str[1]);
				
				
				
				ProductsBean bean = new ProductsBean();
				ProductModel model = new ProductModel();
				
				bean.setProductName(name.toUpperCase());
				
				bean.setCategory(category.toUpperCase());
				bean.setPrice(price);
				bean.setFilename(fileName);
				bean.setPath(uploadPath);
				bean.setNumberofproducts(noOfProducts);
			
			int res = model.updateProducts(bean);
			if(res>=1){
				writer.println("SuccessFull Updated Records");
				RequestDispatcher rd=request.getRequestDispatcher("/UpdateProductsView.jsp");  
		        rd.include(request, response);
			}else{
				writer.println("Not updated Any Records");
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

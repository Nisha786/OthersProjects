package in.com.prestige.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import in.com.prestige.bean.ProductsBean;
import in.com.prestige.model.ProductModel;

/**
 * Servlet implementation class AddBannerImagesCtl
 */
@WebServlet("/AddBannerImagesCtl")

public class AddBannerImagesCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddBannerImagesCtl() {
        super();
     
    }
    
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
		     String fileName = null;
		     String filePath= null;
		     String uploadPath= null;
		     PrintWriter writer = response.getWriter();
		
			// checks if the request actually contains upload file
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
			
			
			ProductsBean bean = new ProductsBean();
			ProductModel model = new ProductModel();
			
			
			bean.setFilename(fileName);
			bean.setPath(uploadPath);
			
			int res = model.bannerImages(bean);
			if(res>=1){
				//writer.println("SuccessFull Inserted");
                HttpSession sess = request.getSession();
                sess.setAttribute("msg", "SuccessFull Inserted");
				RequestDispatcher rd=request.getRequestDispatcher("/AddBannerView.jsp");  
		        rd.forward(request, response);
			}else{
				HttpSession sess = request.getSession();
                sess.setAttribute("msg", "Not Inserted");
				RequestDispatcher rd=request.getRequestDispatcher("/AddBannerView.jsp");  
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

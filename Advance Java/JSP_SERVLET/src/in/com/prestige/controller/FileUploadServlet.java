package in.com.prestige.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import in.com.prestige.bean.ProductsBean;
import in.com.prestige.connection.JDBCUploadConn;
import in.com.prestige.model.ProductModel;

@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

public class FileUploadServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "images";
    public String dbFileName = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	/*response.setContentType("text/html ,charset=UTF-8");
		PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("discription");
        Part part = request.getPart("file");
        String fileName = extractFileName(part);
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
           String savePath = appPath + File.separator + UPLOAD_DIR;
         
            System.out.println(savePath);
            System.out.println(fileName);
       
          part.write(savePath + File.separator + fileName);*/
        
    	response.setContentType("text/html ,charset=UTF-8");
		PrintWriter out = response.getWriter();
		int id =54;
        String name = "Deependra";
        Part filepart = request.getPart("file");
		
		//Part filepart = request.getPart("bannerimg");
		String fileName = extractFileName(filepart);//file name
		String savePath = fileName;
		File fileSaveDir = new File(savePath);
        filepart.write(savePath + File.separator);
        
        
        try {
            Connection conn = null;
            conn = JDBCUploadConn.getConnection();
            PreparedStatement pst = conn.prepareStatement("insert into imagetable values(?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, name);
           
            pst.setString(3, fileName);
            pst.setString(4, savePath);
            pst.executeUpdate();
            out.println("<center><h1>Image inserted Succesfully......</h1></center>");
            out.println("<center><a href='display.jsp?id=" + id + "'>Display</a></center>");
        } catch (Exception e) {
            out.println(e);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(request, response);
    }
    /**
     * Extracts file name from HTTP header content-disposition
     */
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
        

    
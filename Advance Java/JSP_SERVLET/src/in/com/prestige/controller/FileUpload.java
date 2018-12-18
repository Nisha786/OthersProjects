package in.com.prestige.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import in.com.prestige.connection.JDBCUploadConn;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FileUpload() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ,charset=UTF-8");
		PrintWriter out = response.getWriter();

		ServletFileUpload sf  = new ServletFileUpload( new DiskFileItemFactory() );
	    int id = 1;
        String name = "Deepe";
	    try {
			List<FileItem> multifiles =sf.parseRequest(request);
			for(FileItem item :multifiles){
				System.out.println(item.getName());
				try {
					item.write(new File("F:/Prestige Java/AdnavceFiles/JSP_SERVLET/WebContent/images/"+item.getName()));
					/*Connection conn = null;
		            conn = JDBCUploadConn.getConnection();
		            PreparedStatement pst = conn.prepareStatement("insert into imagetable values(?,?,?,?)");
		            pst.setInt(1, id);
		            pst.setString(2, name);
		           
		            pst.setString(3, item.getName());
		            pst.setString(4, item.getName());
		            pst.executeUpdate();
		            out.println("<center><h1>Image inserted Succesfully......</h1></center>");
		            out.println("<center><a href='display.jsp?id=" + id + "'>Display</a></center>");*/
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

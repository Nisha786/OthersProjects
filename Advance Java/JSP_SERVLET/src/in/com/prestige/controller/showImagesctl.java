package in.com.prestige.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import in.com.prestige.connection.JDBCUploadConn;

/**
 * Servlet implementation class showImagesctl
 */
@WebServlet("/showImagesctl")
public class showImagesctl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public showImagesctl() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		
	   // PrintWriter pw = response.getWriter();
	    Connection conn = null;
	    OutputStream output = null;
	    try{
	    	conn  = JDBCUploadConn.getConnection();
	    	String sql = "Select * from imagetable where picid = ?";
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setInt(1, 65465465);
	    	ResultSet rs = ps.executeQuery();
	    	while(rs.next()){
	    		//byte bArray[] = rs.getBytes(3);
                Blob blob = rs.getBlob(3);
                byte byteArray[] = blob.getBytes(1, (int)blob.length());
                response.setContentType("image/jpg");
	    		output = response.getOutputStream();
	    		output.write(byteArray);
	    		
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

package in.com.prestige.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import in.com.prestige.connection.JDBCUploadConn;

/**
 * Servlet implementation class UplaodFilesCtl
 */
@WebServlet("/UplaodFilesCtl")
@MultipartConfig(maxFileSize = 16999999)
public class UplaodFilesCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UplaodFilesCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
		    PrintWriter pw = response.getWriter();
		    Connection conn = null;
		try{
			int id = Integer.parseInt(request.getParameter("picid"));
			String name = request.getParameter("picname");
			Part filepart = request.getPart("picimg");
			System.out.println("Hello : "+id+"-----"+name+"-----"+filepart);
			InputStream inputstrean = null;
			if(filepart!= null){
				long filesize = filepart.getSize();
				String filecontent = filepart.getContentType();
				inputstrean = filepart.getInputStream();
			}
			conn = JDBCUploadConn.getConnection();
			String sql = "Insert into imagetable values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id );
			ps.setString(2, name);
			ps.setBlob(3, inputstrean);
			int i = ps.executeUpdate();
			if(i>=1){
				pw.println("Inserted Sucessfully");
			}else{
				pw.println("Inserted Not");
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

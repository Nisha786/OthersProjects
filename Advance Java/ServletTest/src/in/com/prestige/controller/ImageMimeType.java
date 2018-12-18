package in.com.prestige.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageMimeType
 */
@WebServlet(urlPatterns="/ImageMimeType")
public class ImageMimeType extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    File f = new File("G:/New folder/samsung.jpg");
	    //read File fFrom File System
	    FileInputStream in = new FileInputStream(f);
	    response.setContentType("image/jpg");
	    response.setContentLength((int)f.length());
	    
	    //GetOutputStream Object
	    ServletOutputStream out = response.getOutputStream();
	    byte[] arr = new byte[(int)f.length()];
	    int readBytes = in.read(arr);
	    while(readBytes>0){
	    	out.write(arr, 0, readBytes);
	    	readBytes = in.read(arr);
	    }
	    //close IO Streams
	    in.close();
	    out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

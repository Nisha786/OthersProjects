<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%@ page import = "java.sql.*" %>
     <%@ page import = "java.io.*" %>
     <%@ page import = "in.com.prestige.connection.JDBCUploadConn" %>
     
     
     <%@ page import="java.io.*"%>
 <%@ page import="java.sql.*"%>
 <%@ page import="com.mysql.*"%>
 <%@ page import="java.util.*"%>
  <%@ page import="java.text.*"%>
 <%@ page import="javax.servlet.*"%>
 <%@ page import="javax.servlet.http.*"%>
 <%@ page import="javax.servlet.http.HttpSession"%>
 <%@ page language="java"%>
 <%@ page session="true"%>
 <%@ page import="java.sql.*"%>
<% 
Blob image = null;
Connection conn = null;
 byte[] imgData = null;


try {

conn  = JDBCUploadConn.getConnection();
String sql = "Select * from imagetable";
PreparedStatement ps = conn.prepareStatement(sql);
//ps.setInt(1, 65465465);
ResultSet rs = ps.executeQuery();%>
<table border="2">
<tr><th>DISPLAYING IMAGE</th></tr>
<tr><td>Image 2</td></tr>
<tr><td>
<%while(rs.next()){
	response.setContentType("image/jpg");
	OutputStream o = response.getOutputStream();
 image = rs.getBlob(3);
 imgData = image.getBytes(1,(int)image.length());
 o.write(imgData);
}
%>
 
 
</td></tr>
</table>
<%}
catch (Exception e) {
out.println("DB problem"); 

}

%>
</body>
</html>
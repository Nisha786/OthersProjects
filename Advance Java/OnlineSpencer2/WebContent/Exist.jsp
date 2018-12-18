<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="in.com.prestige.connection.JDBCDataSourceSpencerOnline"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <%
       String email = request.getParameter("email");
       Connection conn = null;
       try{
    	  conn = JDBCDataSourceSpencerOnline.getConnection();
    	  String sql = "select * from customers where email = ?";
    	  PreparedStatement ps = conn.prepareStatement(sql);
    	  ps.setString(1, email);
    	  ResultSet rs = ps.executeQuery();
    	  if(rs.next()){
    		  out.print("Email Already Exists");
    	  }else{
    		  out.print("email is valid");
    	  }
       }catch(Exception e){
    	   
       }
      
      %>
</body>
</html>
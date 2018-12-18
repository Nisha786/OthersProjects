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
  try{
	  Connection conn = null;
	  conn = JDBCDataSourceSpencerOnline.getConnection();
	  String sql = "select * from homepageimages";
	  PreparedStatement ps = conn.prepareStatement(sql);
	  ResultSet rs = ps.executeQuery();
	  while(rs.next()){
		  String filename = rs.getString(2);
		  String path = rs.getString(3);
		  System.out.print(filename);
  %>
  <image src="<%= filename %>"  />
  <%=path%>
	<%  }
  }catch(Exception e){
	  e.printStackTrace();
  }
 
 %> 
  
</body>
</html>
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
   <%@page import = "javax.servlet.http.HttpSession" %>
 <%
    if(session.getAttribute("adminLogin") == null){
    	response.sendRedirect("admin.jsp");
    }
 %>
      <div align="center">
       <table border="1">
       <h3>Welcome: ${adminLogin}</h3>
       <tr><th colspan="5">All Customers List</th></tr>
       
       <tr>
        <th>CustomerId</th>
        <th>Customer Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Action</th>
       </tr>
 
 <%
    try{
      Connection conn = null;
      conn = JDBCDataSourceSpencerOnline.getConnection();
      String sql = "Select * from customers";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
    	int cid = rs.getInt(1);
    	String cname = rs.getString(2);
    	String email = rs.getString(3);
    	String pass = rs.getString(4);
    %>
        
        <tr>
         <td><%= cid %></td>
         <td><%= cname %></td>
         <td><%= email %></td>
         <td><%= pass %></td>
         <td><a href="CustomerDelete.jsp?cid=<%= cid%>">Delete</a>/<a href="CustomerModify.jsp?cid=<%= cid%>&cname=<%= cname%>&email=<%= email%>&pass=<%= pass%>">Modify</a></td>
        </tr>
          
      
    
    <%
      }
    }catch(Exception e){
    	e.printStackTrace();
    }
    %>
     </table>
      <a href="dashboard.jsp">Go To dashBoard</a>
    </div>
</body>
</html>
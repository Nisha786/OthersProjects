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
    <div align="center" >
    <table border="2">
    <h3>Welcome: ${adminLogin}</h3>
    <h3>Update Products</h3>
       <form action="CustomerUpdateCtl" method="post" >
           <table border="1">
           <tr>
           <th>CustomerId</th>
           <td><input type = "text" name = "cid" value = "<%= Integer.parseInt(request.getParameter("cid"))%>" readonly></td>
           </tr>
      
           <tr>
           <th>Customer Name</th>
           <td><input type = "text" name = "cname" value = "<%= request.getParameter("cname")%>"></td>
           </tr>
           <tr>
           <th>Email</th>
           <td><input type = "text" name = "email" value = "<%= request.getParameter("email")%>"></td>
           </tr>
           <tr>
           <th>Password</th>
           <td><input type = "text"  name = "pass" value = "<%= request.getParameter("pass")%>"></td>
           </tr>
           <tr>
            <td colspan="2"><input type = "submit" value = "Update"></td>
           </tr>
           </table>
       </form>
    </table>
     <a href="dashboard.jsp">Go To dashBoard</a>
    </div>  
    
</body>
</html>
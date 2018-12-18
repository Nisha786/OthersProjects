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
  if(request.getAttribute("error") != null){
	  String err = (String)request.getAttribute("error");
%>
<font color="red"><%= err%></font> 
<% 	  
  }else{
%>
<font color="green"><h2>Please Login</h2></font>
<%} %>
<form action="/ServletTest/LoginFrontCTL">
UserId: <input type="text" name="userId">
<input type="submit" value="Login">
</form>

</body>
</html>
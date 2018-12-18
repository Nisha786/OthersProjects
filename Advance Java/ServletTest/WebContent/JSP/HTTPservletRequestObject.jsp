<%@page import="in.com.prestige.controller.BaseView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border="2px">
			<form action="<%= BaseView.HTTPRequestObject%>" method="get">
			<tr>
			    <th>Name</th>
			    <td><input type="text" name="name"></td>
			</tr>
			<tr>
			    <th>Email</th>
			    <td><input type="text" name="email"></td>
			</tr>
			<tr>
			    <th>Password</th>
			    <td><input type="password" name="password"></td>
			</tr>
			<tr>
			    <td><input type="Submit" name="submit" value="Submit"></td>
			</tr>
			</form>
		</table>
	</div>
</body>
</html>
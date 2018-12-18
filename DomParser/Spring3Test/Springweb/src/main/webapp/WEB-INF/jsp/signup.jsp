<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Registation</h1>
	<a href="loginView.do">Login Here</a>
	<form:form method="post" action="registartion.do"
		modelAttribute="userRegisterModel">
		<table border="1" align="center">
			<tr>
				<th>FirstName</th>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<th>LastName</th>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<th>ContactNo</th>
				<td><form:input path="contactNo"/></td>
			</tr>
			 <tr>
			   <td><input type="submit" value="Register"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
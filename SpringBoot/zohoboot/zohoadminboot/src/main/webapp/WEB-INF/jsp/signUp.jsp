<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="registration" modelAttribute="registerMap">
		<table border="1" align="center">
			<tr>
			<td colspan="2"><font color="red"><form:errors path="firstName"/></font></td>
			</tr>
			<tr>
				<th>FirstName</th>
				<td><form:input path="firstName" name="firstName" id="firstName" /></td>
			</tr>
			<tr>
			<td colspan="2"><font color="red"><form:errors path="lastname"/></font></td>
			</tr>
			<tr>
				<th>LastName</th>
				<td><form:input path="lastname" name="lastname" id="lastname" /></td>
			</tr>
			<tr>
			<td colspan="2"><font color="red"><form:errors path="email"/></font></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
			<td colspan="2"><font color="red"><form:errors path="password"/></font></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
			<td colspan="2"><font color="red"><form:errors path="email"/></font></td>
			</tr>
			<tr>
				<th>ContactNo</th>
				<td><form:input path="contactNo" name="contactNo" id="contactNo" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>
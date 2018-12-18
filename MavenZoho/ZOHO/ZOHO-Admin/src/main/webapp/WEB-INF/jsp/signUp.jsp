<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.aartek.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<hr>
	Language :
	<a href="?language=en">English</a>|
	<a href="?language=zh_CN">Chinese</a>|
	<a href="?language=hi">Hindi</a>
	<h1>Registration</h1>
	<form:form method="post" action="registration.do"
		modelAttribute="userRegistrationMap">
		<table border="1" align="center">
			<tr>
				<th><font color="red"><form:errors path="firstName"></form:errors></font></th>
			</tr>
			<tr>
				<th><spring:message code="lable.firstName" text="default text" /></th>
				<td><form:input path="firstName" name="firstName"
						id="firstName" /></td>
			</tr>
			<tr>
				<th><font color="red"><form:errors path="lastName"></form:errors></font></th>
			</tr>
			<tr>
				<th><spring:message code="lable.lastName" text="default text" /></th>
				<td><form:input path="lastName" name="lastName" id="lastName" /></td>
			</tr>
			<tr>
				<th><font color="red"><form:errors path="email"></form:errors></font></th>
			</tr>
			<tr>
				<th><spring:message code="lable.email" text="default text" /></th>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<th><font color="red"><form:errors path="contactNo"></form:errors></font></th>
			</tr>
			<tr>
				<th><spring:message code="lable.contact" text="default text" /></th>
				<td><form:input path="contactNo" name="contactNo"
						id="contactNo" /></td>
			</tr>
			<tr>
				<th><font color="red"><form:errors path="password"></form:errors></font></th>
			</tr>
			<tr>
				<th><spring:message code="lable.password" text="default text" /></th>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
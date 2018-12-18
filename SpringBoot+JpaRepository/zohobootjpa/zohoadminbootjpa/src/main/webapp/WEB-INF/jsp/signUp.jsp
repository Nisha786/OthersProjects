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
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.7/css/jquery.dataTables.css">
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
	<hr>
	<c:set var="count" value="0" scope="page" />
	<c:choose>
		<c:when test="${empty userRecords}">
			<c:out value="No Records Found"></c:out>
		</c:when>
		<c:otherwise>
	<table border="2" align="center" id="example">
				<thead>
					<tr>
						<th>User Id</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Email</th>
						<th>ContactNo</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userRecords}" var="user">
						<c:set var="count" value="${count + 1}" scope="page" />

						<tr>
							<td>${count}</td>
							<td>${user.firstName}</td>
							<td>${user.lastname}</td>
							<td>${user.email}</td>
							<td>${user.contactNo}</td>
							<td><a
								href="<c:url value="#"/>">Delete</a>/<a
								href="<c:url value="#"/>">Edit</a></td>
						</tr>

					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>User Id</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Email</th>
						<th>ContactNo</th>
						<th>Action</th>
					</tr>
				</tfoot>
			</table>
		</c:otherwise>
	</c:choose>
	<hr>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable({
				"pagingType" : "full_numbers"
			});
		});
	</script>
	
</body>
</html>
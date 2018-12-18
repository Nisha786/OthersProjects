<%@page import="com.aartek.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.7/css/jquery.dataTables.css">
</head>
<body>
	<hr>
	<c:choose>
		<c:when test="${empty loginSession}">

		</c:when>
		<c:otherwise>
			<h3 align="right">
				Welcome :
				<c:out value="${loginSession}"></c:out>
				<a href="logout.do">Logout</a>
			</h3>
		</c:otherwise>
	</c:choose>

	<h1>Products Add</h1>
	<form:form method="post" action="products.do"
		modelAttribute="productsMap" enctype="multipart/form-data">
		<table border="1" align="center">
			<tr>
				<th colspan="2"><font color="red"><form:errors path="productname"></form:errors></font></th>
			</tr>
			<tr>
				<th>ProductName</th>
				<td><form:input path="productname" name="productname"
						id="productname" /></td>
			</tr>
			<tr>
				<th colspan="2"><font color="red"><form:errors
							path="productDescription"></form:errors></font></th>
			</tr>
			<tr>
				<th>ProductDescription</th>
				<td><form:input path="productDescription"
						name="productDescription" id="productDescription" /></td>
			</tr>
			<tr>
				<th colspan="2"><font color="red"><form:errors path="price"></form:errors></font></th>
			</tr>
			<tr>
				<th>Price</th>
				<td><form:input path="price" name="price" id="price" /></td>
			</tr>
			<tr>
				<th colspan="2"><font color="red"><form:errors
							path="numberOfProducts"></form:errors></font></th>
			</tr>
			<tr>
				<th>NoOfProduct</th>
				<td><form:input path="numberOfProducts" name="numberOfProducts"
						id="numberOfProducts" /></td>
			</tr>
			<tr>
				<th colspan="2"><font color="red"><form:errors
							path="imagefile"></form:errors></font></th>
			</tr>
			<tr>
				<th>Upload Image</th>
				<td><form:input type="file" path="imagefile" name="imagefile" id="imagefile"/></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add Products"></td>
			</tr>
		</table>
	</form:form>

	<hr>
	<!-- Set A variable -->
	<c:set var="count" value="0" scope="page" />
	<c:choose>
		<c:when test="${empty productRecords}">
			<c:out value="No Records Found"></c:out>
		</c:when>
		<c:otherwise>
			<table border="2" align="center" id="example">
				<thead>
					<tr>
						<th>Product Id</th>
						<th>ProductName</th>
						<th>ProductDescription</th>
						<th>ProductPrice</th>
						<th>Number Of Products</th>
						<th>productImage</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productRecords}" var="product">
						<c:set var="count" value="${count + 1}" scope="page" />

						<tr>
							<td>${count}</td>
							<td>${product.productname}</td>
							<td>${product.productDescription}</td>
							<td>${product.price}</td>
							<td>${product.numberOfProducts}</td>
							<td><img alt="pic" src="upload/${product.fileName}" height="70" width="50"> </td>
						</tr>

					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Product Id</th>
						<th>ProductName</th>
						<th>ProductDescription</th>
						<th>ProductPrice</th>
						<th>Number Of Products</th>
						<th>productImage</th>
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
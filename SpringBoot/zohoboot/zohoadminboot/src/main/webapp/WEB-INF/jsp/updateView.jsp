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
	<h3 align="right">
		Welcome:
		<c:out value="${userLoginSession}"></c:out>
	</h3>
	<a href="<c:url value="/logOutUser"/>">Logout</a>

	<h2 align="center">Add Products</h2>
	<form:form method="post" action="/productsUpdates/uppate"
		modelAttribute="productsMapUpdate" enctype="multipart/form-data">
		<table border="1" align="center">
			<tr>
				<th>ProductId</th>
				<td><form:input path="productId" name="productId"
						id="productId" readonly="true" /></td>
			</tr>
			<tr>
				<th><font color="red"><form:errors path="productName"></form:errors></font></th>
			</tr>
			<tr>
				<th>ProductName</th>
				<td><form:input path="productName" name="productName"
						id="productName" /></td>
			</tr>
			<tr>
				<th><font color="red"><form:errors path="description"></form:errors></font></th>
			</tr>
			<tr>
				<th>ProductDescription</th>
				<td><form:input path="description" name="description"
						id="description" /></td>
			</tr>
			<tr>
				<th><font color="red"><form:errors path="price"></form:errors></font></th>
			</tr>
			<tr>
				<th>Price</th>
				<td><form:input path="price" name="price" id="price" /></td>
			</tr>
			<tr>
				<th><font color="red"><form:errors path="noOfProducts"></form:errors></font></th>
			</tr>
			<tr>
				<th>NoOfProduct</th>
				<td><form:input path="noOfProducts" name="noOfProducts"
						id="noOfProducts" /></td>
			</tr>

			<tr>
				<th><font color="red"><form:errors path="imagefile"></form:errors></font></th>
			</tr>
			<tr>
				<th>Image</th>
				<td><form:input type="file" path="imagefile" name="imagefile"
						id="imagefile" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update"></td>
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
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productRecords}" var="product">
						<c:set var="count" value="${count + 1}" scope="page" />

						<tr>
							<td>${count}</td>
							<td>${product.productName}</td>
							<td>${product.description}</td>
							<td>${product.price}</td>
							<td>${product.noOfProducts}</td>
							<c:forEach items="${product.proImg}" var="proimg">
								<td><img alt="pic" src="upload/${proimg.imgName}"
									height="70" width="50"></td>
							</c:forEach>
							<td><a
								href="<c:url value="/deleteRecord/${product.productId}"/>">Delete</a>/<a
								href="<c:url value="/editRecord/${product.productId}"/>">Edit</a></td>
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
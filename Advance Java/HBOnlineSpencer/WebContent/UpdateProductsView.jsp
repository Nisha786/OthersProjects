<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Projection"%>
<%@page import="org.hibernate.criterion.Projections"%>
<%@page import="org.hibernate.criterion.ProjectionList"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="in.com.prestige.dto.ProductsDTO"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#update')
								.click(
										function(e) {

											var price = $('#price').val();
											var price_regex = new RegExp(
													'^[0-9]+$');

											if (!price_regex.test(price)
													|| price.length == 0) {
												//alert("mail");
												$('#p1').text("only Numbers");
												$("#price").focus();
												return false;
											} else if ($('#picimg').val() == '') {

												var allowedFiles = [ ".jpg",
														".jpeg", ".png" ];
												var fileUpload = $("#picimg");
												var lblError = $("#p2");
												var regex = new RegExp(
														"([a-zA-Z0-9\s_\\.\-:])+("
																+ allowedFiles
																		.join('|')
																+ ")$");
												if (!regex.test(fileUpload
														.val().toLowerCase())) {
													lblError
															.html("Please upload files having extensions: <b>"
																	+ allowedFiles
																			.join(', ')
																	+ "</b> only.");
													return false;
												}

												return false;
											} else if ($('#picimg').val() != '') {

												var allowedFiles = [ ".jpg",
														".jpeg", ".png" ];
												var fileUpload = $("#picimg");
												var lblError = $("#p2");
												var regex = new RegExp(
														"([a-zA-Z0-9\s_\\.\-:])+("
																+ allowedFiles
																		.join('|')
																+ ")$");
												if (regex.test(fileUpload.val()
														.toLowerCase())) {
													lblError
															.html("Please upload files having extensions: <b>"
																	+ allowedFiles
																			.join(', ')
																	+ "</b> only.");
													return true;
												}

												return false;
											} else {
												return true;
											}

										});
					});
</script>
</head>

<body>
	<%@page import="javax.servlet.http.HttpSession"%>
	<%
		if (session.getAttribute("adminLogin") == null) {
			response.sendRedirect("admin.jsp");
		}
		try {
			SessionFactory factory = null;
			Session s = null;
			Transaction txn = null;
			factory = new Configuration().configure().buildSessionFactory();
			s = factory.openSession();
			txn = s.beginTransaction();
			Criteria crit = s.createCriteria(ProductsDTO.class);
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.property("category"));
			projList.add(Projections.groupProperty("category"));
			crit.setProjection(projList);
			List list = crit.list();
			Iterator it = list.iterator();
			//query for getting products name
			Criteria crit2 = s.createCriteria(ProductsDTO.class);
			ProjectionList projList2 = Projections.projectionList();
			projList2.add(Projections.property("productname"));
			crit2.setProjection(projList2);
			List list2 = crit2.list();
			Iterator it2 = list2.iterator();
	%>
	<div align="center">
		<table border="2">
			<h3>Welcome: ${adminLogin}</h3>
			<h3>Update Products</h3>
			<form action="UpdateProductsCtl" method="post"
				enctype="multipart/form-data">
				<tr>
					<td>Category</td>
					<td><select name="category">
							<%
								while (it.hasNext()) {
										Object[] obj = (Object[]) it.next();
							%>
							<option value="<%=obj[0]%>"><%=obj[0]%></option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td>ProductName</td>
					<td><select name="products">
							<%
								while (it2.hasNext()) {
										Object obj = (Object) it2.next();
							%>
							<option value="<%=obj%>"><%=obj%></option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Update Price</td>
					<td><input type="text" name="price" id="price"><font
						id="p1" color="red"></td>
				</tr>
				<tr>
					<td>Status</td>
					<td><input type="text" name="status" id="status"
						value="AVAILABLE" readonly="readonly"><font id="p4"
						color="red"></td>
				</tr>
				<tr>
					<td>Update Number Of Products</td>
					<td><input type="text" name="numberOfProducts" min="1"></td>
				</tr>
				<tr>
					<td>Update Image</td>
					<td><input type="file" name="picimg" id="picimg"><font
						id="p2" color="red"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Update"
						id="update"></td>
				</tr>

			</form>
		</table>
		<a href="dashboard.jsp">Go To dashBoard</a>
	</div>
	<%
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>


</body>
</html>
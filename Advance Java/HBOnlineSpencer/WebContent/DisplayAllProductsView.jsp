<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.com.prestige.dto.ProductsDTO"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
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
</head>
<body>
	<%@page import="javax.servlet.http.HttpSession"%>
	<%
		if (session.getAttribute("adminLogin") == null) {
			response.sendRedirect("admin.jsp");
		}
	%>

	<div align="center">
		<table border="1">
			<h3>Welcome: ${adminLogin}</h3>
			<tr>
				<th colspan="7">All Products List</th>
			</tr>

			<tr>
				<th>ProductId</th>
				<th>Product Name</th>

				<th>Category</th>
				<th>Price</th>
				<th>No.Of Products</th>
				<th>Product Image</th>
				<th>Action</th>
			</tr>

			<%
				try {
					SessionFactory factory = new Configuration().configure().buildSessionFactory();
					Session s = factory.openSession();
					Transaction txn = s.beginTransaction();
					Criteria crit = s.createCriteria(ProductsDTO.class);
					List list = crit.list();
					Iterator it = list.iterator();

					while (it.hasNext()) {
						ProductsDTO product = (ProductsDTO) it.next();
						int pid = product.getProductID();
						String pname = product.getProductname();
						String category = product.getCategory();
						double price = product.getPrice();
						int numberofpro = product.getNumberofproducts();
						String filename = product.getFilename();
			%>

			<tr>
				<td><%=pid%></td>
				<td><%=pname%></td>
				<td><%=category%></td>
				<td><%=price%></td>
				<td><%=numberofpro%></td>
				<td><image src="upload/upload/<%=filename%>" height="50"
						width="50" /></td>
				<td><a href="#">Delete</a></td>
			</tr>



			<%
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		</table>
		<a href="dashboard.jsp">Go To dashBoard</a>
	</div>
</body>
</html>
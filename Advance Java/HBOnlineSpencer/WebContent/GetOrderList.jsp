<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.com.prestige.dto.OrderListDTO"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
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
				<th>OrderId</th>
				<th>Customers ID</th>

				<th>Contact No</th>
				<th>ProductName</th>
				<th>No.Of Products</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>

			<%
				try {
					SessionFactory factory = new Configuration().configure().buildSessionFactory();
					Session s = factory.openSession();
					Transaction txn = s.beginTransaction();
					Criteria crit = s.createCriteria(OrderListDTO.class);
					List list = crit.list();
					Iterator it = list.iterator();

					while (it.hasNext()) {
						OrderListDTO product = (OrderListDTO) it.next();
						int oid = product.getOrderid();
						String cid = product.getCustomersID();
						String pname = product.getProductName();
						int contact = product.getContactNo();
						double price = product.getPrice();
						int numberofpro = product.getQuantity();
						
			%>

			<tr>
				<td><%=oid%></td>
				<td><%=cid%></td>
				<td><%=contact%></td>
				<td><%=pname%></td>
				<td><%=numberofpro%></td>
				<td><%=price%></td>
				<td><%=numberofpro%></td>
				
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
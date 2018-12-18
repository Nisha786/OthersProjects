<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.com.prestige.dto.CustomerDTO"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.cfg.Configuration"%>
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
				<th colspan="6">All Customers List</th>
			</tr>

			<tr>
				<th>CustomerId</th>
				<th>Customer Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Contact No</th>
				<th>Action</th>
			</tr>

			<%
				try {
					SessionFactory factory = null;
					Session s = null;
					Transaction txn = null;
					factory = new Configuration().configure().buildSessionFactory();
					s = factory.openSession();
					txn = s.beginTransaction();
					Criteria crit = s.createCriteria(CustomerDTO.class);
					List list = crit.list();
					Iterator it = list.iterator();
					while (it.hasNext()) {
						CustomerDTO cust = (CustomerDTO)it.next();
						int cid = cust.getCustomersID();
						String cname = cust.getName();
						String email = cust.getEmail();
						String pass = cust.getPassword();
						String phone = cust.getContactno();
			%>

			<tr>
				<td><%=cid%></td>
				<td><%=cname%></td>
				<td><%=email%></td>
				<td><%=pass%></td>
				<td><%=phone%></td>
				<td><a href="CustomerDelete.jsp?cid=<%=cid%>">Delete</a>/<a
					href="CustomerModify.jsp?cid=<%=cid%>&cname=<%=cname%>&email=<%=email%>&pass=<%=pass%>&contact=<%=phone%>">Modify</a></td>
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
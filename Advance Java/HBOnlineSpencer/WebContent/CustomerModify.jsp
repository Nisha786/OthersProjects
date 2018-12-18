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

											var cname = $('#cname').val();
											var cemail = $('#email').val();
											var cpass = $('#pass').val();
											var cphone = $('#contact').val();
											var email_regex = new RegExp(
													'^[a-zA-Zs][a-zA-Z0-9]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$');
											var name_regex = new RegExp(
													'^[a-zA-Z ]+$');
											var pass = new RegExp(
													'^[a-zA-Z0-9]+$');
											var phone = new RegExp('\\d{10}');
											if (!name_regex.test(cname)
													|| cname.length == 0) {
												$('#p1')
														.text(
																"For your name please use alphabets only");
												$("#cname").focus();
												return false;
											} else if (!email_regex
													.test(cemail)
													|| cemail.length == 0) {
												//alert("mail");
												$('#p2').text(
														"Not a Valid Email");
												$("#email").focus();
												return false;
											} else if (!phone.test(cphone)
													|| cphone.length == 0) {
												alert("phone");
												$('#p4')
														.text(
																"Not a Valid PhoneNumber");
												$("#cphone").focus();
												return false;
											} else if (!pass.test(cpass)
													|| cpass.length == 0) {
												$('#p3').text(
														"Password is Required");
												$("#pass").focus();
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
	%>
	<div align="center">
		<table border="2">
			<h3>Welcome: ${adminLogin}</h3>
			<h3>Update Products</h3>
			<form action="CustomerUpdateCtl" method="post">
				<table border="1">
					<tr>
						<th>CustomerId</th>
						<td><input type="text" name="cid"
							value="<%=Integer.parseInt(request.getParameter("cid"))%>"
							readonly></td>
					</tr>

					<tr>
						<th>Customer Name</th>
						<td><input type="text" name="cname" id="cname"
							value="<%=request.getParameter("cname")%>"><font id="p1"
							color="red"></font></td>
					</tr>
					<tr>
						<th>Email</th>
						<td><input type="text" name="email" id="email"
							value="<%=request.getParameter("email")%>"><font id="p2"
							color="red"></font></td>
					</tr>
					<tr>
					<tr>
						<th>Contact No</th>
						<td><input type="text" name="contact" id="contact"
							value="<%=request.getParameter("contact")%>"><font id="p4"
							color="red"></font></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><input type="text" name="pass" id="pass"
							value="<%=request.getParameter("pass")%>"><font id="p3"
							color="red"></font></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Update"
							id="update"></td>
					</tr>
				</table>
			</form>
		</table>
		<a href="dashboard.jsp">Go To dashBoard</a>
	</div>

</body>
</html>
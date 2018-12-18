<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String rn = request.getParameter("roll");
		if ("123".equals(rn)) {
			request.setAttribute("success", "Login Succefull");
	%>
	<jsp:forward page="RollNo.jsp"></jsp:forward>
	<%
		}else{
			request.setAttribute("error", "RollNo UIs not Found");
	%>
	<jsp:forward page="RollNo.jsp"></jsp:forward>
	<%
		}
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Online Result</h1>
    <%
    String str = (String)request.getAttribute("error");
    if(str!=null){
     %>
       <font color="red"><%= str%></font> 
    <% 	
    }else{
    %>
      <font color="green"><%= request.getAttribute("success")%></font>
    <%} %>
    
    <form action="RollNoCTL.jsp">
     <input type="text" name="roll">
     <input type="submit" value="Sibmit">
    </form>
</body>
</html>
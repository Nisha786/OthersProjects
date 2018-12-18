<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <jsp:useBean id="stu" class="in.com.prestige.controller.StudentBean" scope="page"/>
   <jsp:setProperty property="rollNo" name="stu" value="123"/>
   <jsp:setProperty property="name" name="stu" value="Deependra"/>
   <jsp:setProperty property="no" name="stu" value="85%"/>
   
   RollNo : <jsp:getProperty property="rollNo" name="stu"/>
   Name   : <jsp:getProperty property="name" name="stu"/>
   Number : <jsp:getProperty property="no" name="stu"/> 
</body>
</html>
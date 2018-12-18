<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="in.com.prestige.dto.CustomerDTO"%>
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
      <%
       String email = request.getParameter("email");
       
       try{
    	  SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	  Session s = factory.openSession();
    	  Transaction txn = s.beginTransaction();
    	  Criteria crit = s.createCriteria(CustomerDTO.class);
    	  crit.add(Restrictions.eq("email", email));
    	  List list = crit.list();
    	  
    	  if(list.size()>=1){
    		  out.print("Email Already Exists");
    	  }else{
    		  out.print("email is valid");
    	  }
    	  
       }catch(Exception e){
    	   
       }
      
      %>
</body>
</html>
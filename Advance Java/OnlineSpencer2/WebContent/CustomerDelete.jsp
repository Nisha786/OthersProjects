<%@page import="in.com.prestige.model.CustomerModel"%>
<%@page import="java.io.PrintWriter"%>
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
        response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int cid  = Integer.parseInt(request.getParameter("cid"));
		
		try{
		    
		    CustomerModel model = new CustomerModel();
		   int res = model.deleteUserEntry(cid);
		    if(res>=1){
		    	
		    	RequestDispatcher rd = request.getRequestDispatcher("/GetCustomersList.jsp");
		    	rd.include(request, response);
		    }
		    else{
		    	
		    	RequestDispatcher rd = request.getRequestDispatcher("/GetCustomersList.jsp");
		    	rd.include(request, response);
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
	
        %>
</body>
</html>
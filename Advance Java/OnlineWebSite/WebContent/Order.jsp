<%@page import="in.com.prestige.utility.JavaMailUtility"%>
<%@page import="in.com.prestige.model.CustomerModel"%>
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
         
        try{
        	String pname = (String)session.getAttribute("productname");
        	double price = (Double)session.getAttribute("price");
        	int quantity = Integer.parseInt((String)session.getAttribute("quantity"));
        	String email = (String)session.getAttribute("userLoginsession");
        	
        	CustomerModel model = new CustomerModel();
        	int res = model.bookOrder(pname, email, price, quantity);
        	if(res>=1){
        		JavaMailUtility.sendOrderEmail(pname, email, quantity,price);
        		int i = model.deleteBookedItems(quantity, pname);
        		if(i>=1){
        			session.invalidate();
        			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
        			rd.include(request, response);
        		}else{
        			session.invalidate();
        			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
        			rd.include(request, response);
        		}
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }
      
      %>
  
</body>
</html>
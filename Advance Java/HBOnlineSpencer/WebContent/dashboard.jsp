<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import = "javax.servlet.http.HttpSession" %>
 <%
    if(session.getAttribute("adminLogin") == null){
    	response.sendRedirect("admin.jsp");
    }
 %>
 <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <h3 > Dashboard  Welcome  : ${adminLogin}</h3>
            <h3 class="page-header"><i class="fa fa-laptop"></i><a href="LogOutCtl">Logout</a></h3>
            <ol class="breadcrumb" text-align = "center">
              
              <li><a href="ProductAddView.jsp">Add Products</a></li>
              <li><a href="UpdateProductsView.jsp">Update Products</a></li>
              <li><a href="CustomersAddView.jsp">Add Customers</a></li>
              <li></i><a href="GetCustomersList.jsp">Get Customers List</a></li>
              <li></i><a href="DisplayAllProductsView.jsp">Display Stock</a></li>
              <li></i><a href="GetOrderList.jsp">Order List</a></li>
               <li></i><a href="AddBannerView.jsp">Add Home Page Images</a></li>
              
            </ol>
          </div>
        </div>

        
</section>
</section>

    



 </body>
</html>
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
     <div align="center" >
    <table border="2">
    <h3>Welcome: ${adminLogin}</h3>
    <h3>Add Products</h3>
       <form action="ProductCtl" method="post" enctype="multipart/form-data">
           <tr>
             <td>Product Name</td>
             <td><input type="text" name = "pname" id = "pname"></td>
           </tr>
           <tr>
             <td>Product Price</td>
             <td><input type="text" name = "price" id ="price"></td>
           </tr>
           <tr>
            <td>Status</td>
             <td><input type="text" name = "status" value = "Available"></td>
           </tr>
           <tr>
             <td>Category</td>
             <td><select name="category" >
                 <option value="Mobile">Mobiles</option>
                 <option value="Electronics">Electronics</option>
             </select></td>
           </tr>
           <tr>
            <td>Number Of Produts</td>
             <td><input type="number" name = "noOfProducts"  ></td>
           </tr>
           <tr>
          <td>Product Image : </td>
          <td><input type= "file" name ="picimg"></td>
        </tr>
           <tr >
             <td colspan="2"><input type="submit" value = "Submit"></td>
           </tr>
       </form>
    </table>
     <a href="dashboard.jsp">Go To dashBoard</a>
    </div>  
</body>
</html>
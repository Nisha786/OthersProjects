<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
 $(document).ready(function() {
	$('#submit').click(function(e) {
		
		 var pname = $('#pname').val();
		 var price = $('#price').val();
		 var price_regex  = new RegExp('^[0-9]+$');
		 var name_regex = new RegExp('^[a-zA-Z0-9_ ]*$');
		
		if (!name_regex.test(pname) || pname.length == 0) {
			$('#p1').text("please use varchar only");
			$("#pname").focus();
			return false;
		}else if(!price_regex.test(price) || price.length == 0) {
			//alert("mail");
			$('#p2').text("only Numbers"); 
			$("#price").focus();
			return false;
		}
		else if($('#picimg').val() == ''){
			
			var allowedFiles = [".jpg", ".jpeg", ".png"];
            var fileUpload = $("#picimg");
            var lblError = $("#p3");
            var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
            if (!regex.test(fileUpload.val().toLowerCase())) {
            	lblError.html("Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.");
            	return false;
            }
            
            return false;
		}else if($('#picimg').val() != ''){
			
			var allowedFiles = [".jpg", ".jpeg", ".png"];
            var fileUpload = $("#picimg");
            var lblError = $("#p3");
            var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
            if (regex.test(fileUpload.val().toLowerCase())) {
            	lblError.html("Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.");
            	return true;
            }
            
            return false;
		}
		else {
			return true;
		}
	
	});
});
 </script>
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
             <td><input type="text" name = "pname" id = "pname"><font id = "p1" color = "red"></font></td>
           </tr>
           <tr>
             <td>Product Price</td>
             <td><input type="text" name = "price" id ="price"><font id = "p2" color = "red"></font></td>
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
             <td><input type="number" name = "noOfProducts" id = "noOfProducts" min = "1" ></td>
           </tr>
           <tr>
          <td>Product Image : </td>
          <td><input type= "file" name ="picimg" id = "picimg"><font id = "p3" color = "red"></font></td>
        </tr>
           <tr >
             <td colspan="2"><input type="submit" value = "Submit" id = "submit"></td>
           </tr>
       </form>
    </table>
     <a href="dashboard.jsp">Go To dashBoard</a>
    </div>  
</body>
</html>
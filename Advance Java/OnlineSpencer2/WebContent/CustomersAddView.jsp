<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
 $(document).ready(function() {
	$('#submit').click(function(e) {
		
		var cname = $('#cname').val();
		 var cemail = $('#cemail').val();
		 var cpass = $('#cpwd').val();
		var email_regex =  new RegExp('^[a-zA-Zs][a-zA-Z0-9]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$');
		var name_regex = new RegExp('^[a-zA-Z ]+$');
		var pass =new RegExp('^[a-zA-Z0-9]+$');
		if (!name_regex.test(cname) || cname.length == 0) {
			$('#p1').text("For your name please use alphabets only");
			$("#cname").focus();
			return false;
		}else if(!email_regex.test(cemail) || cemail.length == 0) {
			alert("mail");
			$('#p2').text("Not a Valid Email"); 
			$("#cemail").focus();
			return false;
		}
		else if(!pass.test(cpass) || cpass.length == 0) {
			$('#p3').text("Password is Required"); 
			$("#cpass").focus();
			return false;
		}
		else {
			return true;
		}
	
	});
});
	 
</script>
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
       <form action="CustomersAdminCtl" method="post">
           <tr>
             <td>Customer Name</td>
             <td><input type="text" name="cname" id="cname" ><font id = "p1" color = "red"></font></td>
           </tr>
           <tr>
             <td>Email</td>
             <td><input type="email" name="cemail" id="cemail" ><font id = "p2"  color = "red"></font></td>
           </tr>
          <tr>
             <td>Password</td>
             <td><input type="password" name="cpwd"  id="cpwd" ><font id = "p3"  color = "red"></font> </td>
           </tr>
           <tr >
             <td colspan="2"><input type="submit" value = "Submit" id="submit"></td>
           </tr>
       </form>
    </table>
     <a href="dashboard.jsp">Go To dashBoard</a>
    </div>  
</body>
</html>
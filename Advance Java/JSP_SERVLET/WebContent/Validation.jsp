<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src = "js/validationJquery.js">
	 
</script>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border="1">
			
			 <font color="red" id="head"></font> 
			<form action="validationCtl" method="get" enctype="multipart/form-data">
				<tr>
					<th>Username</th>
					<td><input type="text" name="username" value="" id="username"><font color="red" id="p1"></font>
					</td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="pass" id="pass"><font color="red" id="p2"></font></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><input type="text" name="add" id="add"><font color="red" id="p4"></font></td>
				</tr>
				<tr>
					<th>Image</th>
					<td><input type="file" name="file" id="file"><font color="red" id="p3"></font></td>
				</tr>
				<tr>

					<td><input type="submit"  value="submit"
						id="submit"></td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>
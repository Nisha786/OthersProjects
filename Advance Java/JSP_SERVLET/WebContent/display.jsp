<%@page import="java.sql.PreparedStatement"%>
<%@page import="in.com.prestige.connection.JDBCUploadConn"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Image Show</title>
    </head>
    <body>
        

        <table style="width:100%">
            <tr>
                <th>Id</th>
                <th>Image</th>

            </tr>
            <tr>
                <td>1</td><td>
                <td><td><image src="upload/upload/Lg 670.jpg" width="200" height="200"/></td>

            </tr>
        </table>
        
    <center><a href="viewAll.jsp">View All </a></center>
</body>
</html>

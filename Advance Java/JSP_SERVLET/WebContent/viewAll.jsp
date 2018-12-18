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
        <%
            try {
                Connection conn = null;
                conn = JDBCUploadConn.getConnection();
                String sql = "SELECT * FROM imagetable";
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    
                    String filename = rs.getString(3);
                    String path = rs.getString(4);
        %>

        <table style="width:100%" border="2">
            <tr>
                <th>Id</th>
                <th> Name</th>
               
                <th>Image</th>
                <th>Path</th>
            </tr>
            <tr>
                <td><%=id%></td>
                <td><%=name%></td>
               
                <td><img src="<%=filename%>" width="150" height="200"/></td>
                <td><%=path%></td>
            </tr>
        </table>
        <%
                }
            } catch (Exception e) {
                out.println(e);
            }
        %>
    </body>
</html>

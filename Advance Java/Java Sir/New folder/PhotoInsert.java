 import java.sql.*;
 import java.io.*;
 class PhotoInsert
 {
     public static void main(String args[])throws Exception
     {
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","root");

       PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?,?)");
       ps.setInt(1,236);
       ps.setString(2,"Neeraj Paliwal");
       ps.setFloat(3,7000);

       File f=new File("Neeraj.jpg");
       FileInputStream fis=new FileInputStream(f);
       ps.setBinaryStream(4,fis,(int)f.length());


	   ps.executeUpdate();

       fis.close();
       ps.close();
       con.close();
       }//main
  }//class
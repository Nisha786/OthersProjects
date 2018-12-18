 import java.sql.*;
 import java.io.*;
 class BinaryLargeObjectInsert
 {
     public static void main(String args[])
     {
		 PreparedStatement ps=null;
       Connection con =null;
	   try
	   {
	   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
		//ps=con.prepareStatement("create table ImageFile(id int primary key,name varchar(20),salary int,image blob)");
       //ps.executeUpdate();
	   
	   ps=con.prepareStatement("insert into ImageFile values(?,?,?,?)");
       ps.setInt(1,100);
       ps.setString(2,"Manish");
       ps.setFloat(3,10000);

       File f=new File("mani.jpg");
       FileInputStream fis=new FileInputStream(f);
       ps.setBinaryStream(4,fis,(int)f.length());


	   ps.executeUpdate();

       fis.close();
       ps.close();
       con.close();
       }
	   
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   
	   
	   //main
  }//class
 }
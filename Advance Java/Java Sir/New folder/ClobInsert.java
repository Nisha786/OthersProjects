 import java.sql.*;
 import java.io.*;
 import java.util.*;
 class ClobInsert
 {
     public static void main(String args[])throws Exception
     {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter no : ");
       int no = sc.nextInt();
       System.out.println("Enter Student Name : ");
       String sname = sc.next();
       System.out.println("Enter Student Address : ");
       String address = sc.next();
       System.out.println("Enter Student Resume : ");
       String resumePath = sc.next();

       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Prestige","root","root");
       
       PreparedStatement ps=con.prepareStatement("insert into  Student values(?,?,?,?)");
       File file=new File(resumePath);
       long length=file.length();
       FileReader reader=new FileReader(file);
       ps.setInt(1,no);
       ps.setString(2,sname);
       ps.setString(3,address);
       ps.setCharacterStream(4,reader,(int)length);
       int result=ps.executeUpdate();
       if(result==0)
          System.out.println("Record not inserted");
       else
          System.out.println("Record  inserted");
       reader.close();
       ps.close();
       con.close();
       }//main
  }//class
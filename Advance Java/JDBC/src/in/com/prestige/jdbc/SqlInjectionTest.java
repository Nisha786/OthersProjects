package in.com.prestige.jdbc;

import java.sql.*;
import java.io.*;


public class SqlInjectionTest {
	
	
		public static String DB_URL = "jdbc:mysql://localhost:3306/test";
		public static String user = "root";
		public static String pass = "root";
		public static int id = 0;
		public static String username = null;
		
	   public static void main(String[] args){
		 Connection conn = null;
		 Statement st = null;
		 ResultSet rs = null;
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(DB_URL,user,pass);
			 st = conn.createStatement();
			 System.out.println("Enter User Id : ");
			 int userId = Integer.parseInt(br.readLine());
			 
			 System.out.println("Enter Username : ");
			 String name = br.readLine();
			 
			 rs = st.executeQuery("Select empid,empname from employee where empid = '"+userId+"' and empname = '"+name+"'");
			 while(rs.next()){
				 id = rs.getInt(1);
				 username = rs.getString(2);
			 }
	      		 if(id == userId && name.equals(username)){
	      			 System.out.println("Valid Credentials");
	      		 }else{
	      			System.out.println(" Not Valid Credentials");
	      		 }
			 
		 }catch(Exception e){
			 System.out.println(e);
		 }
	   }
	}



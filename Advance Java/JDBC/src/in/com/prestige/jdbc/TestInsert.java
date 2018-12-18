package in.com.prestige.jdbc;
import java.sql.*;

public class TestInsert {
   public static String db_url = "jdbc:mysql://localhost:3306/test";
   public static String username = "root";
   public static String password = "root";
   
   public static void main(String[] args){
	   Connection conn = null;
	   Statement st = null;
	   ResultSet rs = null;
	   
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection(db_url,username,password);
		   st = conn.createStatement();
		   int i = st.executeUpdate("insert into employee values(107,'Gaurav Ravi','Bangali Square','sdfgsd4545','uiuy78',78945612,'D3',6005.00)");
	        if(i >= 1){
	        	System.out.println("Record Inserted");
	        }else{
	        	System.out.println("Record  Not Inserted");
	        }
	   }catch(Exception e){
		   System.out.println(e);
	   }finally{
		   try{
			   if(conn!=null){
				   conn.close();
			   }
			   if(st!=null){
				   st.close();
			   }
		   }catch(Exception e){
			   System.out.println(e);
		   }
	   }
   }
}

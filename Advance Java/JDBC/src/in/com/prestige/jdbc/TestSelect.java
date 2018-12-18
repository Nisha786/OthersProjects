package in.com.prestige.jdbc;
import java.sql.*;

public class TestSelect {
	 public static String db_url = "jdbc:mysql://localhost:3306/test";
	 public static String username = "root";
	 public static String password = "root";
  public  static void main(String[] args){
	  Connection conn = null;
	  Statement st  = null;
	  ResultSet rs = null;
	  
	  try{
		  Class.forName("com.mysql.jdbc.Driver");
		  conn = DriverManager.getConnection(db_url,username,password);
		   st = conn.createStatement();
		   rs  = st.executeQuery("Select * from employee");
		  
		  while(rs.next()){
			  System.out.println(rs.getInt(1) + "---"+ rs.getString(2)+ "----"+rs.getString(3));
		  }
		  
	  }catch(Exception e){
		  System.out.println(e);
	  }
	  finally{
		  try{
			  if(conn!= null){
				 conn.close();
			  }
			  if(st!=null){
				  st.close();
			  }
			  if(rs!=null){
				  rs.close();
			  }
		  }catch(Exception e){
			  System.out.println(e);
		  }
	  }
  }
}

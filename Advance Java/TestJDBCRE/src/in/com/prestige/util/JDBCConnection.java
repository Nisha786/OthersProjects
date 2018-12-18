package in.com.prestige.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
   private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbcrevision";
   private static final String user = "root";
   private static final String pwd = "root";
   private static Connection conn = null;
   //private Constructor
   private JDBCConnection(){
	   
   }
   public static Connection getConnection() throws Exception{
       try{
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(DB_URL, user, pwd);
       }catch(Exception e){
    	   e.printStackTrace();
       }
	   return conn;
   }
}

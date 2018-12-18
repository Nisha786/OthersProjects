package MetaData;
import java.io.*;
import java.sql.*;
public class DatabaseMetaDataDemo {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","root");
        DatabaseMetaData dbmd = con.getMetaData();
        System.out.println("Class that implements DatabaseMetaData(I) is " + dbmd.getClass().getName());
        System.out.println("Database Name :" + dbmd.getDatabaseProductName());
        System.out.println("Database Version :" + dbmd.getDatabaseProductVersion());
        System.out.println("JDBC Driver Version :"+dbmd.getDriverVersion());
        System.out.println("SQL Key Words: "+ dbmd.getSQLKeywords());
        System.out.println(dbmd.allProceduresAreCallable()); 
	 
	}
}
        

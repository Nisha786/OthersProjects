package MetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TestResultSetMetaData {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String qry = "Select * from Student1 ";
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","root");
        Statement st=con.createStatement();
         ResultSet rs = st.executeQuery(qry);
         ResultSetMetaData rsmd = rs.getMetaData();
         int columnCount = rsmd.getColumnCount();
         for(int i = 1;i<=columnCount;i++)
         {
        	 System.out.print(rsmd.getColumnLabel(i)+ "\t\t");
         }
         System.out.println("\n");
         //datatype
         for(int i = 1;i<=columnCount;i++)
         {
        	 System.out.print(rsmd.getColumnTypeName(i)+ "\t\t");
         }
         System.out.println("\n");
         while(rs.next())
         {
        	 System.out.print(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
        	 System.out.println();
         }
       rs.close();
       st.close();
       con.close();
	}

}

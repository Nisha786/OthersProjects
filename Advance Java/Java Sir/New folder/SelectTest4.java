//With Java Coding Standard
package select;
import java.sql.*;
import java.util.*;
public class SelectTest4 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner sc=null;
		try {
			//read inputs
			 sc = new Scanner(System.in);
			String offCode1=null,offCode2=null,offCode3=null;
			if (sc != null)
			{
			 System.out.println("Enter officecode1");
			 offCode1=sc.next();
			 System.out.println("Enter officecode2");
			 offCode2=sc.next();
			 System.out.println("Enter officecode3");
			 offCode3=sc.next();
			}//if
			//prepare condition as required for SQL query
			//(4,6,7)
			String cond ="('"+offCode1+"','"+offCode2+"','"+offCode1+"')";
			//register jdbc Driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Establish Connection
	         con= DriverManager.getConnection("jdbc:odbc:ds","root","root");
		    if(con!=null)
		    	st=con.createStatement();
		    //prepare SQL Query
		    String qry = "Select EmployeeNumber from employees where officecode in "+cond;
		   //send and execute SQL Query in DB S/W
		    if(st!=null)
		    rs = st.executeQuery(qry);
		    //process the result set
		    boolean flag =false;
		    if(rs!=null)
		    {
		    	while(rs.next())
		        {
		         System.out.println(rs.getInt(1));	
		         flag=true; 
		        }//while
		    	
		    }//if
		if(flag==false)
			System.out.println("Records not found");
		}//try
		catch(ClassNotFoundException cnf) 
		    { System.out.println(cnf.toString()); }
		catch(SQLException se)
		{ System.out.println(se.toString()); }
        catch(Exception e) {
        	e.printStackTrace();
        }
		finally
		{
			//close jdbc objs
			try {
				if(rs!=null) { rs.close();}
			    }
			catch(SQLException se){se.printStackTrace();}
			try {
				if(st!=null)
				{
					st.close();
				}
			}
			catch(SQLException se){se.printStackTrace();}
			try {
				if(con!=null)
				{
					con.close();
				}
			}
			catch(SQLException se){se.printStackTrace();}
			try {
				if(sc!=null)
				{
					sc.close();
				}
			}
			catch(Exception se){se.printStackTrace();}
			
			}
        }
}
        
              



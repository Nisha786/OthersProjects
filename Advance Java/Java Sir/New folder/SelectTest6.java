package select;
import java.sql.*;
import java.util.*;
public class SelectTest6 {

	public static void main(String[] args) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Intial Character for employee last name");
		String intialChar = sc.next();
		intialChar ="'"+intialChar+"%'";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con= DriverManager.getConnection("jdbc:odbc:ds","root","root");
        Statement st=con.createStatement();
        String qry = "Select EmployeeNumber,lastname from employees where lastname like "+intialChar;
        ResultSet rs = st.executeQuery(qry);
        boolean flag=false;
        while(rs.next())
        {flag=true;
         System.out.println(rs.getInt(1)+"  "+rs.getString(2));	
         
        }
        if(flag==false)
        	System.out.println("No Records Found");
        rs.close();
        st.close();
        con.close();
        sc.close();
	}

}

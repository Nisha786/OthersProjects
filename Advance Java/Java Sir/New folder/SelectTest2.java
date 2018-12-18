package select;
import java.sql.*;
import java.util.*;
public class SelectTest2 {

	public static void main(String[] args) throws Exception{
		
	Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
        String name = sc.next();
		name="'"+name+"'"; 
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con= DriverManager.getConnection("jdbc:odbc:ds","root","root");
        Statement st=con.createStatement();
        ResultSet rs = st.executeQuery("select * from Student1 where name ="+name);
        boolean flag=false;
        while(rs.next()!=false)
        {
         System.out.println(rs.getInt(1)+"  "+rs.getString(2)+ "  "+rs.getString(3));	
         flag=true;
        }
        if(flag==false)
        	System.out.println("No Records Found");
        rs.close();
        st.close();
        con.close();
        sc.close();
	}

}

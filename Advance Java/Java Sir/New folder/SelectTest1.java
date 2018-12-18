package select;
import java.sql.*;
public class SelectTest1 {

	public static void main(String[] args) throws Exception{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //type 1 driver
        Connection con= DriverManager.getConnection("jdbc:odbc:cc1","root","root");
        Statement st=con.createStatement();
       
        ResultSet rs = st.executeQuery("select * from student");
       
        while(rs.next())
        {
         System.out.println(rs.getString(1)+ "  "+rs.getString(2)+" " +rs.getInt(3));	
        }
        System.out.println(con.getClass().getName());
        System.out.println(st.getClass().getName());
        System.out.println(rs.getClass().getName());
        rs.close();
        
        st.close();
        con.close();
	}

}

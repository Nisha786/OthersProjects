package select;
import java.sql.*;
import java.util.*;
public class SelectTest3 {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Start  roll no");
		int Rno = sc.nextInt();
		System.out.println("Enter End  roll no");
		int Rno1 = sc.nextInt();
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con= DriverManager.getConnection("jdbc:odbc:ds","root","root");
        Statement st=con.createStatement();
        String qry = "Select * from Student1 where rollno >="+Rno+" and rollno<="+Rno1;
        ResultSet rs = st.executeQuery(qry);
        boolean flag=false;
        while(rs.next())
        {flag=true;
         System.out.println(rs.getInt(1)+"  "+rs.getString(2)+ "  "+rs.getString(3));	
         
        }
        if(flag==false)
        	System.out.println("No Records Found");
        rs.close();
        st.close();
        con.close();
        sc.close();
	}

}

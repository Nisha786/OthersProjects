package insert;
import java.sql.*;
import java.util.*;
public class DeleteTest {

	public static void main(String[] args) throws Exception{
		
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Enter employeeNumber ");
		//int eno = sc.nextInt();
		Class.forName("com.mysql.jdbc.Driver");
		String qry = "insert into employee values (?,?,?,?,?) ";
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Prestige","root","root");
                //disable autocommit mode on DB S/W
        //con.setAutoCommit(false);
        PreparedStatement st=con.prepareStatement(qry);
         st.setInt(1,1621);
         st.setString(2,"Neeraj");
         st.setString(3, "xyz");
         st.setFloat(4, 4890.5f);
         st.setString(5,"d2");
         
        //Statement st = con.createStatement();
       int i= st.executeUpdate();          //executeQuery(qry);
       // int result = st.executeUpdate(qry);
        //commit or rollback
      // con.commit(); // or
        //con.rollback();
        //process the result
         if(i==1)
        	System.out.println("Record inserted Successfully");
         else
        	 System.out.println("Record not inserted Successfully");
        
        st.close();
        con.close();
	}

}

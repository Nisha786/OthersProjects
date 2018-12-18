package insert;
import java.sql.*;
import java.util.*;
public class InsertMultipleRecords {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Records you want to insert : ");
		int noOfRecords = sc.nextInt();
		Class.forName("com.mysql.jdbc.Driver");
		String qry = "insert into employee values (?,?,?,?,?) ";
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Prestige","root","root");
                //disable autocommit mode on DB S/W
         con.setAutoCommit(false);
        PreparedStatement st=con.prepareStatement(qry);
        int i=1;
        while(i<=noOfRecords)
        {
        	System.out.println("Enter values for record no : "+i);
        	System.out.println("Enter employee id for record no "+i);
        	int employeeid=sc.nextInt();
        	System.out.println("Enter employee Name for record no "+i);
        	String name=sc.next();
        	System.out.println("Enter employee Address for record no "+i);
        	String address=sc.next();
        	System.out.println("Enter employee Salary for record no "+i);
        	float salary=sc.nextFloat();
        	System.out.println("Enter employee depart No for record no "+i);
        	String deptid=sc.next();
        	st.setInt(1,employeeid);
            st.setString(2,name);
            st.setString(3, address);
            st.setFloat(4, salary);
            st.setString(5,deptid);
            int result = st.executeUpdate();
            if(result>0)
            	System.out.println(i+"  record is inserted successfuly");
            else
            	System.out.println(i+"  record is not inserted successfuly");
            i++;
            
        	
        }
         
         
        //Statement st = con.createStatement();
       //int i= st.executeUpdate();          //executeQuery(qry);
       // int result = st.executeUpdate(qry);
        //commit or rollback
       con.commit(); // or 
       //con.rollback();
        //process the result
      //   if(i==1)
       // 	System.out.println("Record inserted Successfully");
       //  else
        //	 System.out.println("Record not inserted Successfully");
        
        st.close();
        con.close();
	}

}

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;

public class BatchProcessDemo {
	public static void main(String args[])throws Exception
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver Loaded");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","root");
	System.out.println("connection established");
	con.setAutoCommit(false);
	st=con.createStatement();
			
	System.out.println("statement prepared");
	st.addBatch("insert into student1 values(801,'Ram','Indore')");
	st.addBatch("update student1 set surname='xyz' where rollno=103");
	st.addBatch("delete from student1 where rollno=800");

	int res[]=st.executeBatch();
    int sum=0; 
	for(int i=0;i<res.length;++i)
			{
				sum=sum+res[i];
			}
	System.out.println("no.of records that are effected is"+sum);
           boolean flag=true;
		for(int i=0;i<res.length;++i)
			{
				if(res[i]==0)
				{
					flag=false;
					break;
				}
			}
			if(flag)
				con.commit();
			else
				con.rollback();	

		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
			 
}



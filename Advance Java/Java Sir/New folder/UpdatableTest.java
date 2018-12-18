// prg on Updatable ResultSet

import java.sql.*;
public class UpdatableTest
{
	public static void main(String args[])throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","root");
 		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from student");
                  con.setAutoCommit(false);
		/*   System.out.println("updates the 3th record");
			rs.absolute(3);
			rs.updateString(2,"pali 4");
			rs.updateRow();
                     con.commit(); */

  			/*System.out.println("Inserting new row");
			rs.moveToInsertRow(); //creates an empty record in ResultSet obj
			rs.updateInt(1,334);
			rs.updateString(2,"Neeraj");
			rs.updateString(3,"Mumbai");
			rs.insertRow();*/


    /*   System.out.println("deleting 2 th row");
			rs.absolute(2);
			rs.deleteRow();  */

	/*	while(rs.next())  //top to bottom
		{
				System.out.println(rs.getString(1)+"  "+rs.getString(2));
		} */
       /*     rs.afterLast();
          while(rs.previous())  // bottom to top
		{
				System.out.println(rs.getString(1)+"  "+rs.getString(2));
		} */
           rs.absolute(2);
                 System.out.println(rs.getString(1)+"  "+rs.getString(2));
           rs.relative(-1);
                System.out.println(rs.getString(1)+"  "+rs.getString(2));
			rs.close();
			st.close();
			con.close(); 
	
	}//main
}//class


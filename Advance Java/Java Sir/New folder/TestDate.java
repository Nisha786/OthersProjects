 import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class TestDate {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	public static void main(String args[]) throws Exception {
	makeConnection();
	DataInputStream dis = new DataInputStream(System.in);
		
	System.out.println("Enter date in YYYY-MM-DD format :");
	String d1 = dis.readLine();

	System.out.println("Enter date in DD-MMM-YYYY format :");
	String d2 = dis.readLine();

	System.out.println("Enter date in DD-MM-YYYY format :");
	String d3 = dis.readLine();

	//YYYY-MM-DD
	ps.setString(1,"YYYY-MM-DD");
	ps.setDate(2, java.sql.Date.valueOf(d1));

	int res = ps.executeUpdate();
	if(res == 1)
	System.out.println(" No Problem in YYYY-MM-DD format .");
	else
   	 	System.out.println("  Problem in YYYY-MM-DD format .");

	//DD-MMM-YYYY
       //Convert String Date values to java.sql.Date class Object
	ps.setString(1,"DD-MMM-YYYY");

	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
	java.util.Date ud1 = sdf1.parse(d2);
	java.sql.Date sd1 = new java.sql.Date(ud1.getTime());
	ps.setDate(2, sd1);

	res = ps.executeUpdate();
	if(res == 1)
   		System.out.println(" No Problem in DD-MMM-YYYY format .");
	else
		System.out.println("  Problem in DD-MMM-YYYY format .");

	//DD-MM-YYYY
	ps.setString(1,"DD-MM-YYYY");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
	java.util.Date ud2 = sdf2.parse(d3);
	java.sql.Date sd2 = new java.sql.Date(ud2.getTime());
	ps.setDate(2, sd2);

	res = ps.executeUpdate();
	if(res == 1)
		System.out.println(" No Problem in DD-MM-YYYY format .");
	else
		System.out.println("  Problem in DD-MM-YYYY format .");

	// Printing dates of DB as received.
	rs = st.executeQuery("SELECT * FROM DATE_TEST_TABLE"); 
	while(rs.next()){
		String fname = rs.getString(1);

		String fvalue = rs.getString(2);   //YYYY-MM-DD Format
		System.out.println(fname + "\t" + fvalue);
		}

	System.out.println("\n\n\n"); 

	// Printing dates of table in DD-MMM-YYYY format.
//rs = st.executeQuery("SELECT * FROM DATE_TEST_TABLE");
	rs.beforeFirst();
         	while(rs.next()){
	   	String fname = rs.getString(1);
			
		java.sql.Date fdate = rs.getDate(2);
		SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy");
	    java.util.Date utilDate = (java.util.Date)fdate;
	    String formattedValue = sd.format(utilDate);

	System.out.println(fname + "\t" + formattedValue);
		} //while 
		rs.close();
		st.close();
		ps.close();
		con.close();

	}    //main()

	static void makeConnection()	{
		try{

		Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","root");

                 con.setAutoCommit(true);
		String stmt;
		stmt = "INSERT INTO DATE_TEST_TABLE VALUES(?, ?)";
		ps = con.prepareStatement(stmt);
		st =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		} //try
		catch(SQLException e){
			e.printStackTrace();
		} 
                catch(ClassNotFoundException e){
			e.printStackTrace();
		} //catch
	}   // makeConnection()
} //class
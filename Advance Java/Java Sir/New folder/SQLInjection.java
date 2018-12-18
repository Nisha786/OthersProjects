import java.sql.*;
import java.util.*;
class SQLInjection {
public static void main(String[] args) throws ClassNotFoundException,SQLException
{
Scanner s = new Scanner(System.in);
System.out.println("Enter UserName :");
String user = s.nextLine();
System.out.println("Enter Password :");
String pass = s.nextLine();
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","root");
Statement st = con.createStatement();
String qry="select count(*) from Student where username='"+user+"' and password='"+pass+"'";
ResultSet rs= st.executeQuery(qry);
int cnt = 0;
if(rs.next())
 {
  cnt=rs.getInt(1);
 }
if(cnt==0)
  System.out.println("Invalid Credentials ");
else
  System.out.println("Valid Credentials ");
rs.close();
st.close();
con.close();
}
}
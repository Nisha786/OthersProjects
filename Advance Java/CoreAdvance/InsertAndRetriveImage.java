import java.io.*;
import java.sql.*;

class InsertAndRetriveImage{
      public  String DB_URL = "jdbc:mysql://localhost:3306/test";
      public  String userName = "root";
      public  String pass  = "root";

      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null
       
       public static boolean addImage(FileInputStream fin){
       	Class.forName("Com.mysql.jdbc.Driver");
       	conn = DriverManager.getConnection(DB_URL,userName,pass);
       	String sql = "insert into imagetable values (?,?,?)";
       	ps = conn.prepareStatemen(sql);
        
        ps.setInt(1,102);
        ps.setString(2,"MyImage");
        ps.setBinaryStream(3,fin);

       	int i = ps.executeUpdate();

         if(i>=1){
         	System.out.println("Record Affected");
         }else{
         	System.out.println("Not Insertes Into Table");
         }

	public static void main(String[] args) {
        FileInputStream fin = new FileInputStream("F:/Prestige Java/Advance Java/CoreAdvance/Lock.jpg");
        addImage(fin);
	}
}
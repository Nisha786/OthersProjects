package in.com.prestige.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.com.prestige.bean.CustomerBean;
import in.com.prestige.connection.JDBCDataSourceSpencer;

public class CustomerModel {
   public CustomerModel(){
	   
   }
   
 //for Next AutoIncremented CustomerId
   public int nextCustomerId() throws Exception{
   	 Connection conn = null;
   	 int pk = 0;
   	 try{
   		 conn = JDBCDataSourceSpencer.getConnection();
   		 String sql = "select max(customerid) from customers";
   		 PreparedStatement ps = conn.prepareStatement(sql);
   		 ResultSet rs = ps.executeQuery();
   		 while(rs.next()){
   			 pk = rs.getInt(1);
   		 }
   		 rs.close();
   	 }catch(Exception e){
   		 e.printStackTrace();
   	 }finally{
   		 JDBCDataSourceSpencer.closeConnection(conn);
   	 }
   	 return pk+1;
   }
   
   //for add customers Details into database
   public int addCustomers(CustomerBean bean){
	   Connection conn = null;
	   int pk = 0;
	   int res = 0;
	   try{
		   conn = JDBCDataSourceSpencer.getConnection();
		   pk = nextCustomerId();
		   conn.setAutoCommit(false);
		   String sql = "insert into customers values(?,?,?,?,?)";
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setInt(1, pk);
		   ps.setString(2, bean.getFname());
		   ps.setString(3, bean.getLname());
		   ps.setString(4, bean.getGender());
		   ps.setInt(5, bean.getContactNumber());;
		   res  = ps.executeUpdate();
		   conn.commit();
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{
		   try{
		   
		   JDBCDataSourceSpencer.closeConnection(conn);
		   
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }
	   
	   return res;
   }
}

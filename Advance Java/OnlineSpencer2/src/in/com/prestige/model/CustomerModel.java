package in.com.prestige.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import in.com.prestige.bean.CustomerBean;
import in.com.prestige.connection.JDBCDataSourceSpencerOnline;

public class CustomerModel {
     public CustomerModel(){}
     
     //for next autoIncemented Customers Id
     public int nextCustomerId() throws Exception{
    	 Connection conn = null;
    	 int pk = 0;
    	 try{
    		 conn = JDBCDataSourceSpencerOnline.getConnection();
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
    		 JDBCDataSourceSpencerOnline.closeConnection(conn);
    	 }
    	 return pk+1;
    }
     
     //for add Record In database
     public int addCustomers(CustomerBean bean) throws Exception{
    	 Connection conn = null;
    	 int pk = nextCustomerId();
    	 int res = 0;
    	 try{
    		 conn = JDBCDataSourceSpencerOnline.getConnection();
    		 String sql = "insert into customers values(?,?,?,?)";
    		 conn.setAutoCommit(false);
    		 PreparedStatement ps = conn.prepareStatement(sql);
    		 ps.setInt(1, pk);
    		 ps.setString(2, bean.getName());
    		 ps.setString(3, bean.getEmail());
    		 ps.setString(4, bean.getPassword());
    		 
    		 res = ps.executeUpdate();
    		 conn.commit();
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 JDBCDataSourceSpencerOnline.txnRollback(conn);
    		 JDBCDataSourceSpencerOnline.closeConnection(conn);
    	 }
    	 return res;
     }
     
     //for user login credentilas
     public ArrayList checUserLogin(String username,String password) throws Exception{
    	 Connection conn  = null;
    	 String res = null;
    	 ArrayList list = new ArrayList();
    	 //String username = null;
    	 //String password = null;
    	 try{
    		 conn = JDBCDataSourceSpencerOnline.getConnection();
    		 String sql = "select email , password from customers where email = ? and password = ?";
    		 conn.setAutoCommit(false);
    		 PreparedStatement ps = conn.prepareStatement(sql);
    		 ps.setString(1, username);
    		 ps.setString(2, password);
    		 ResultSet rs = ps.executeQuery();
    		 conn.commit();
    		 while(rs.next()){
    			CustomerBean bean = new CustomerBean();
    			bean.setName(rs.getString(1));
    			bean.setPassword(rs.getString(2));
    			list.add(bean);
    		 }
    		 //if(username.equals(bean.getName()) && password.equals(bean.getPassword())){
    		//	 res = username;
    		// }else{
    		//	 res = "Not Valid User id or Password";
    		// }
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 JDBCDataSourceSpencerOnline.txnRollback(conn);
    		 JDBCDataSourceSpencerOnline.closeConnection(conn);
    	 }
    	 return list;
     }
     
     //For Delte user Entry from cuostomerslist
     public int deleteUserEntry(int cid)throws Exception{
    	 Connection conn  = null;
    	 int res = 0;
    	 try{
    		conn = JDBCDataSourceSpencerOnline.getConnection();
    		conn.setAutoCommit(false);
    		String sql = "delete from customers where customerid = ?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, cid);
    		res = ps.executeUpdate();
    		conn.commit();
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 JDBCDataSourceSpencerOnline.txnRollback(conn);
    		 JDBCDataSourceSpencerOnline.closeConnection(conn);
    	 }
    	 
    	 return res;
     }
     
     //for update customersData
     public int updateUserEntry(int cid,CustomerBean bean) throws Exception{
    	 Connection conn = null;
    	 int res = 0;
    	 try{
    		 conn = JDBCDataSourceSpencerOnline.getConnection();
    		 conn.setAutoCommit(false);
    		 String sql = "update customers set customername = ?,email = ?,password = ? where customerid = ?";
    		 PreparedStatement ps = conn.prepareStatement(sql);
    		 ps.setString(1, bean.getName());
    		 ps.setString(2, bean.getEmail());
    		 ps.setString(3, bean.getPassword());
    		 ps.setInt(4, cid);
    		 res = ps.executeUpdate();
    		 conn.commit();
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 try{
    		 JDBCDataSourceSpencerOnline.txnRollback(conn);
    		 JDBCDataSourceSpencerOnline.closeConnection(conn);
    		 }catch(Exception e){
    			 e.printStackTrace();
    		 }
    	 }
    	 return res;
     }
     
     
     //add Booking Record in orderlist
     public int bookOrder(String pname,String email,double price,int quantity) throws Exception{
    	 Connection conn = null;
    	 int res = 0;
    	 try{
    		 conn = JDBCDataSourceSpencerOnline.getConnection();
    		 conn.setAutoCommit(false);
    		 String sql = "insert into orderlist values(?,?,?,?)";
    		 PreparedStatement ps = conn.prepareStatement(sql);
    		 ps.setString(1, email);
    		 ps.setString(2, pname);
    		 ps.setDouble(3, price);
    		 ps.setInt(4, quantity);
    		 res = ps.executeUpdate();
    		 conn.commit();
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 try{
    		 JDBCDataSourceSpencerOnline.txnRollback(conn);
    		 JDBCDataSourceSpencerOnline.closeConnection(conn);
    		 }catch(Exception e){
    			 e.printStackTrace();
    		 }
    	 }
    	 return res;
     }
     
     //delete record from productlist
     public int deleteBookedItems(int qua,String pname)throws Exception{
    	 Connection conn = null;
    	 int res = 0;
    	 int products = 0;
    	 int total = 0;
    	 try{
    		 conn = JDBCDataSourceSpencerOnline.getConnection();
    		 String sql = "select * from products where productname = ?";
    		 PreparedStatement ps = conn.prepareStatement(sql);
    		 ps.setString(1, pname);
    		 ResultSet rs = ps.executeQuery();
    		 if(rs.next()){
    			 products = rs.getInt(6);
    		 }
    		 total = (products - qua);
    		 String sql2 = "update products set number_products = ? where productname = ?";
    		 PreparedStatement ps2 = conn.prepareStatement(sql2);
    		 ps2.setInt(1,total );
    		 ps2.setString(2, pname);
    		 res = ps2.executeUpdate();
    		 
    		
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 try{
    		 
    		 JDBCDataSourceSpencerOnline.closeConnection(conn);
    		 }catch(Exception e){
    			 e.printStackTrace();
    		 }
    	 }
    	 return res;
     }     
}

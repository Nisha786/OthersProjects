package in.com.prestige.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;




import in.com.prestige.bean.ProductsBean;

import in.com.prestige.connection.JDBCDataSourceSpencer;


public class ProductModel {
    public ProductModel(){
    	
    }
    
    //for Next AutoIncremented ProductID
    public int nextProductId() throws Exception{
    	 Connection conn = null;
    	 int pk = 0;
    	 try{
    		 conn = JDBCDataSourceSpencer.getConnection();
    		 String sql = "select max(productid) from products";
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
    
    //for adding products details into database
    public int addProducts(ProductsBean bean){
       Connection conn = null;
 	   int pk = 0;
 	   int res = 0;
 	   
 	   try{
 		   conn = JDBCDataSourceSpencer.getConnection();
 		   pk  = nextProductId();
 		   conn.setAutoCommit(false);
 		   String sql = "insert into products values(?,?,?,?)";
 		   PreparedStatement ps = conn.prepareStatement(sql);
 		   ps.setInt(1, pk);
 		   ps.setString(2, bean.getProductName().toUpperCase());
 		   ps.setDouble(3, bean.getPrice());
 		   ps.setString(4, bean.getStatus().toUpperCase());
 		   res = ps.executeUpdate();
 		   conn.commit();
 	   }catch(Exception e){
 		   e.printStackTrace();
 	   }finally{
 		   try{
 			   
 			   JDBCDataSourceSpencer.closeConnection(conn);
 		   }catch (Exception e) {
			 e.printStackTrace();
 		   }
 	   }
 	   return res;
    }
    
    //for check products Availability
    public int checkProductAvail(String pname) throws Exception{
    	Connection conn = null;
    	int count = 0;
    	try{
    		conn = JDBCDataSourceSpencer.getConnection();
    		conn.setAutoCommit(false);
    		String sql = "select count(productname) from products where productname = ? group by status having status = ?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1, pname.toUpperCase());
    		ps.setString(2, "AVAILABLE");
    		ResultSet rs = ps.executeQuery();
    		conn.commit();
    		while(rs.next()){
    			count = rs.getInt(1);
    		}
    		rs.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally {
			
			if(conn != null){
				try{
					JDBCDataSourceSpencer.closeConnection(conn);
					JDBCDataSourceSpencer.txnRollback(conn);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
    	return count;
    }
    
    //Show All Prodcuts
    public ArrayList displayProducts() throws Exception{
    	Connection conn = null;
    	ArrayList list = new ArrayList();
    	try{
    		
    		conn = JDBCDataSourceSpencer.getConnection();
    		String sql = "Select * from products where status = ?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1, "AVAILABLE");
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()){
    			ProductsBean bean = new ProductsBean();
    			bean.setProductId(rs.getInt(1));
    			bean.setProductName(rs.getString(2));
    			bean.setPrice(rs.getDouble(3));
    			list.add(bean);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally {
			try{
				JDBCDataSourceSpencer.closeConnection(conn);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
    	return list;
    }
    
    //for add record in booklist for every user booking
    public String bookProdcuts(int customerId,String productName,int numberOfProducts) throws Exception{
    	   Connection conn = null;
		   PreparedStatement pst = null;
		   PreparedStatement pst2 = null;
		   PreparedStatement pst3 = null;
		   PreparedStatement pst4 = null;
		   ResultSet rs = null;
		   ResultSet rs2 = null;
		   double price = 0.0;
		   int count = 0;
		   String response = null;
		   try{
			   
			   conn = JDBCDataSourceSpencer.getConnection();
			   conn.setAutoCommit(false);
			   String sql = "select productprice,productname from products where productname = ? and status = 'AVAILABLE' ";
			   String sql2 = "select count(productname) from products  where productname = ? group by status having status = 'AVAILABLE'";
			   
			   pst = conn.prepareStatement(sql);
			   pst.setString(1, productName.toUpperCase());
			   rs = pst.executeQuery();
			   conn.commit();
			   
			   pst2 = conn.prepareStatement(sql2);
			   pst2.setString(1, productName.toUpperCase());
			   rs2 = pst2.executeQuery();
			   
			   while(rs2.next()){
				   count = rs2.getInt(1);
			   }
			   while(rs.next()){
				   if(productName.toUpperCase().equals(rs.getString(2)) && count>=numberOfProducts){
					   price = rs.getDouble(1);
				   }else{
					   response = "Products or Number  of Products  are  Not Available in Store";
					   //System.out.println("Products or Number  of Products  are  Not Available in Store");
					   break;
				   }
				   
			   }
			   
			   //for insert values in booklist
			   if(count >= numberOfProducts){
			   String sql3 = "insert into bookList values(?,?,?,?)";
			   pst3 = conn.prepareStatement(sql3);
			   
			   pst3.setInt(1, customerId );
			   pst3.setString(2,productName );
			   pst3.setInt(3, numberOfProducts);
			   pst3.setDouble(4,(price*numberOfProducts));
			   pst3.executeUpdate();
			   
			   
			   //And also delete booked record details from product table
			   String sql4 = "delete from products where productname = ? order by productname  limit ?";
			   pst4 = conn.prepareStatement(sql4);
			   
			   pst4.setString(1, productName);
			   pst4.setInt(2, numberOfProducts);
			   pst4.executeUpdate();
			   conn.commit();
			   response = "Products are Booked";
			   //System.out.println("Products are Booked");
			   }
			   
		   }catch(Exception e){
			   System.out.println(e);
		   }finally{
			   try{
				   JDBCDataSourceSpencer.closeConnection(conn);

			   }catch(Exception e){
				  e.printStackTrace(); 
			   }
		   }
		   return response;
    }
    
    
    //for calculating costs
    public String calculateNetAmount(int customerId,double discount) throws Exception{
    	   Connection conn = null;
		   PreparedStatement pst = null;
		   PreparedStatement pst2 = null;
		   ResultSet rs = null;
		   ResultSet rs2 = null;
		   
		   int custId = 0;
		   String custName = null;
		   double totalAmount = 0.0;
		   String response = null;
		   try{
			   conn = JDBCDataSourceSpencer.getConnection();
			   conn.setAutoCommit(false);
			  
			   String sql = "select customerId, firstname from customers where customerId = ?";
			   pst = conn.prepareStatement(sql);
			   pst.setInt(1, customerId);
			   rs = pst.executeQuery();
			   conn.commit();
			    while(rs.next()){
			    	custId = rs.getInt(1);
			    	custName = rs.getString(2);
			    }
			  
			   
			   // select record from booklist
			   String sql2 = "select sum(productprice) from booklist where customerID = ? ";
			   pst2 = conn.prepareStatement(sql2);
			   pst2.setInt(1, customerId);
			   rs2 = pst2.executeQuery();
			   conn.commit();
			   while(rs2.next()){
				  totalAmount = rs2.getDouble(1); 
			   }
			   if(custId == customerId){
				   response = custName + ": YOUR TOTAL AMOUNT IS := "+(totalAmount-discount);
			   //System.out.println(custName + ": YOUR TOTAL AMOUNT IS := "+(totalAmount-discount));
			   }else{
				   response = "Sorry User Not Exists";
				   //System.out.println("Sorry User Not Exists");
			   }
			   
		   }catch(Exception e){
			   System.out.println(e);
			   try{
				   conn.rollback();
			   }catch(Exception e1){
				   e1.printStackTrace();
			   }
		   }finally{
			   try{
				   JDBCDataSourceSpencer.closeConnection(conn);
				   pst.close();
				   pst2.close();
				   rs.close();
				   rs2.close();
			   }catch(Exception e){
				   System.out.println(e);
			   }
		   }
		   return response;
    }
}

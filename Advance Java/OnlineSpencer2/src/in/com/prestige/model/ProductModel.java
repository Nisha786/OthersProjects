package in.com.prestige.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.com.prestige.bean.ProductsBean;
import in.com.prestige.connection.JDBCDataSourceSpencerOnline;



public class ProductModel {
    public ProductModel(){	
    }
    
    //for Next AutoIncremented ProductID
    public int nextProductId() throws Exception{
    	 Connection conn = null;
    	 int pk = 0;
    	 try{
    		 conn = JDBCDataSourceSpencerOnline.getConnection();
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
    		 JDBCDataSourceSpencerOnline.closeConnection(conn);
    	 }
    	 return pk+1;
    }
    
    
  //for Next AutoIncremented ProductID
    public int nextBannerId() throws Exception{
    	 Connection conn = null;
    	 int pk = 0;
    	 try{
    		 conn = JDBCDataSourceSpencerOnline.getConnection();
    		 String sql = "select max(bannerid) from homepageimages";
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
    
    
    //for adding products details into database
    public int addProducts(ProductsBean bean){
       Connection conn = null;
  	   int pk = 0;
  	   int res = 0;
  	   
  	   try{
  		   conn = JDBCDataSourceSpencerOnline.getConnection();
  		   pk  = nextProductId();
  		   conn.setAutoCommit(false);
  		   String sql = "insert into products values(?,?,?,?,?,?,?,?)";
  		   PreparedStatement ps = conn.prepareStatement(sql);
  		   ps.setInt(1, pk);
  		   ps.setString(2, bean.getProductName().toUpperCase());
  		   ps.setString(3, bean.getStatus().toUpperCase());
  		   ps.setString(4, bean.getCategory());
  		   ps.setDouble(5, bean.getPrice());
  		   ps.setInt(6, bean.getNumberofproducts());
  		   ps.setString(7, bean.getFilename());
  		   ps.setString(8, bean.getPath());
  		   res = ps.executeUpdate();
  		   conn.commit();
  	   }catch(Exception e){
  		   e.printStackTrace();
  	   }finally{
  		   try{
  			   JDBCDataSourceSpencerOnline.txnRollback(conn);
  			   JDBCDataSourceSpencerOnline.closeConnection(conn);
  		   }catch (Exception e) {
 			 e.printStackTrace();
  		   }
  	   }
  	   return res;
     }
    
    //for update products in Database
    public int updateProducts(ProductsBean bean)throws Exception{
    	Connection conn = null;
    	int res = 0;
    	try{
    		 conn = JDBCDataSourceSpencerOnline.getConnection();
    		 conn.setAutoCommit(false);
    		   String sql = "update products set productname = ?,price = ?,filename = ?,path = ? ,number_products = ? where productname = ? and category = ?";
    		   PreparedStatement ps = conn.prepareStatement(sql);
    		   ps.setString(1, bean.getProductName());
    		   ps.setDouble(2, bean.getPrice());
    		   ps.setString(3, bean.getFilename());
    		   ps.setString(4, bean.getPath());
    		   ps.setInt(5, bean.getNumberofproducts());
    		   ps.setString(6, bean.getProductName());
    		   ps.setString(7, bean.getCategory());
    		   res = ps.executeUpdate();
    		   conn.commit();
    	}catch(Exception e){
   		   e.printStackTrace();
   	   }finally{
   		   try{
   			   JDBCDataSourceSpencerOnline.txnRollback(conn);
   			   JDBCDataSourceSpencerOnline.closeConnection(conn);
   		   }catch (Exception e) {
  			 e.printStackTrace();
   		   }
   	   }
    	return res;
    }
    
    //for add Banner Images
    public int bannerImages(ProductsBean bean) throws Exception{
    	Connection conn = null;
   	    int pk = 0;
   	   int res = 0;
   	   
   	   try{
   		   conn = JDBCDataSourceSpencerOnline.getConnection();
   		   pk = nextBannerId();
   		   conn.setAutoCommit(false);
   		   String sql = "insert into homepageimages values(?,?,?)";
   		   PreparedStatement ps = conn.prepareStatement(sql);
   		   ps.setInt(1,pk );
   		   ps.setString(2, bean.getFilename());
   		   ps.setString(3, bean.getPath());
   		   res = ps.executeUpdate();
   		   conn.commit();
   	   }catch(Exception e){
   		   e.printStackTrace();
   	   }finally{
   		   try{
   			   JDBCDataSourceSpencerOnline.txnRollback(conn);
   			   JDBCDataSourceSpencerOnline.closeConnection(conn);
   		   }catch (Exception e) {
  			 e.printStackTrace();
   		   }
   	   }
   	   return res;
    }
}

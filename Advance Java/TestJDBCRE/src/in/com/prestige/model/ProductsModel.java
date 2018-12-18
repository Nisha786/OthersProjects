package in.com.prestige.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import in.com.prestige.bean.ProductBean;
import in.com.prestige.util.JDBCConnection;



public class ProductsModel {
    //add Primary Key
	
	public static int nextPk()throws Exception{
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int pk = 0;
		try{
			conn = JDBCConnection.getConnection();
			conn.setAutoCommit(false);
			String sql = "select max(productid) from products";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				pk = rs.getInt(1);
			}
			conn.commit();
			
		}catch (Exception e) {
			if(conn!=null){
				conn.rollback();
			}
			e.printStackTrace();
		}finally {
			conn.close();
			rs.close();
			ps.close();
		}
		return pk+1;
	}
	
	//Add Products Using Batch Processing
	public int[] addProducts()throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		int pk = nextPk();
		int[] arr = {};
		try{
			conn = JDBCConnection.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into products values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,pk);
			ps.setString(2, "TV");
			ps.setDouble(3, 1000.00);
			ps.setString(4, "Availbale");
			ps.setInt(5, 10);
			ps.addBatch();
			
			ps.setInt(1,pk+1);
			ps.setString(2, "Cooler");
			ps.setDouble(3, 1000.00);
			ps.setString(4, "Availbale");
			ps.setInt(5, 10);
			ps.addBatch();
			
			ps.setInt(1,pk+2);
			ps.setString(2, "Laptop");
			ps.setDouble(3, 1000.00);
			ps.setString(4, "Availbale");
			ps.setInt(5, 10);
			ps.addBatch();
			arr =  ps.executeBatch();
			int i = 0;
		    for(int c :arr){
		    	i++;
		    	System.out.println("Record inserted : "+i);
		    }
		    conn.commit();
		}catch (Exception e) {
			 conn.rollback();
		}finally {
			conn.close();
		}
		return arr;
	}
}

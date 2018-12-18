package in.com.prestige.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.com.prestige.bean.CustomerBean;
import in.com.prestige.util.JDBCConnection;

public class CustomerModel {
	// Get Primarykey
	public static Integer getPK() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pk = 0;
		try {
			conn = JDBCConnection.getConnection();
			String sql = "select max(customerId) from customers";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return pk + 1;
	}

	// Add Customers
	public void addCustomers(CustomerBean bean) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		int pk = 0;
		int i = 0;
		try {
			conn = JDBCConnection.getConnection();
			conn.setAutoCommit(false);
			pk = getPK();
			String sql = "insert into customers values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pk);
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getContactNo());
			ps.setString(4, bean.getAddress());
			i = ps.executeUpdate();
			if(i>0){
				System.out.println("Record Inserted");
			}else{
				System.out.println("Record Not Inserted");
			}
			conn.commit();

		} catch (Exception e) {
			if (conn != null) {
				conn.rollback();
			}
			e.printStackTrace();
		} finally {
			conn.close();
			ps.close();
		}

	}
	
	//Get ALl Customers
	public void getCustomers() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		try{
			conn = JDBCConnection.getConnection();
			String sql = "select * from customers";
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();
			while(res.next()){
				System.out.println(res.getInt(1)+"--"+res.getString(2)+"...."+res.getString(3));
			}
		}catch (Exception e) {
			if (conn != null) {
				conn.rollback();
			}
			e.printStackTrace();
		} finally {
			conn.close();
			ps.close();
		}
	}
}

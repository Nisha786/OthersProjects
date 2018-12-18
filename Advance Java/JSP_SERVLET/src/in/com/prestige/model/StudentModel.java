package in.com.prestige.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.com.prestige.bean.StudentBean;
import in.com.prestige.connection.JDBCDataSource;

public class StudentModel {
     public StudentModel(){
    	 
     }
     
     //For Next AutoIncremneted StudentId
     public Integer nextStudentId() throws Exception{
    	 Connection conn  = null;
    	 PreparedStatement pstm = null;
    	 int pk = 0;
    	 try{
    		 conn = JDBCDataSource.getConnection();
    		 //Class.forName("com.mysql.jdbc.Driver");
    		// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdemo","root","root");
    		 pstm = conn.prepareStatement("Select max(studentid) from students");
    		 ResultSet rs = pstm.executeQuery();
    		 while(rs.next()){
    			 pk = rs.getInt(1);
    		 }
    		 rs.close();
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 //conn.close();
    		 JDBCDataSource.closeConnection(conn);
    	 }
    	 return pk+1;
     }
     
     //Add Student Details Into DataBase
     public int addStudent(StudentBean bean) throws Exception{
    	 Connection conn = null;
    	 int pk = 0;
    	 int res = 0;
    	 try{
    		 conn = JDBCDataSource.getConnection();
    		// Class.forName("com.mysql.jdbc.Driver");
    		 //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdemo","root","root");
    		 pk = nextStudentId();
    		 conn.setAutoCommit(false);
    		 String sql = "Insert into students values(?,?,?,?,?)";
    		 PreparedStatement ps = conn.prepareStatement(sql);
    		 ps.setInt(1, pk);
    		 ps.setString(2, bean.getName());
    		 ps.setString(3, bean.getGender());
    		 ps.setString(4, bean.getAddress());
    		 ps.setInt(5, bean.getContactNo());
    		 
    		 res = ps.executeUpdate();
    		 conn.commit();
    		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 JDBCDataSource.closeConnection(conn);
    		 //conn.close();
    		 try{
    			 if(conn!=null){
    				 JDBCDataSource.txnRollBack(conn);
    				 //conn.rollback();
    			 }
       		 }catch(Exception e){
    			e.printStackTrace();
    		 } 
    	 }
    	 return res;
     }
}

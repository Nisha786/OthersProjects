package in.com.prestige.connection;

import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUploadConn {
private static JDBCUploadConn datasource;
    
    private JDBCUploadConn(){
    	
    }
    
    private ComboPooledDataSource cpds = null;
    
    public static JDBCUploadConn getInstance(){
    	if(datasource == null){
    		ResourceBundle rb = ResourceBundle.getBundle("in.com.prestige.bundle.uploadFiles");
    		datasource = new JDBCUploadConn();
    		datasource.cpds = new ComboPooledDataSource();
    		try{
    			datasource.cpds.setDriverClass(rb.getString("driver"));
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		datasource.cpds.setJdbcUrl(rb.getString("db_url"));
    		datasource.cpds.setUser(rb.getString("username"));
    		datasource.cpds.setPassword(rb.getString("password"));
    	}
    	return datasource;
    }
    
    //getConnection from combopool connection
    public static Connection getConnection() throws Exception{
    	return getInstance().cpds.getConnection();
    }
    
    //close the copnnection
    public static void closeConnection(Connection conn){
    	if(conn!=null){
    		try{
    		   conn.close();	
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    }
    
    //rollBack
    public static void txnRollBack(Connection conn) throws Exception{
    	if(conn != null){
    		try{
    			conn.rollback();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    }
}

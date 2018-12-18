package in.com.prestige.connection;

import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCDataSourceSpencerOnline {
   private static JDBCDataSourceSpencerOnline datasource;
   
   private JDBCDataSourceSpencerOnline(){
	   
   }
   
   private ComboPooledDataSource cpds = null;
   
   public static JDBCDataSourceSpencerOnline getInstance(){
	   if(datasource == null){
		   ResourceBundle rb = ResourceBundle.getBundle("in.com.prestige.bundle.system");
		   datasource = new JDBCDataSourceSpencerOnline();
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
   
   public static Connection getConnection() throws Exception{
	   return getInstance().cpds.getConnection();
   }
   
   public static void closeConnection(Connection conn) throws Exception{
	   if(conn!=null){
		   try{
		   conn.close();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }
   }
   
   public static void txnRollback(Connection conn)throws Exception{
	   if(conn!=null){
		   try{
			   conn.rollback();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }
   }
}

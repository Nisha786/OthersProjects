package in.com.prestige.spencer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.com.prestige.connection.DataSource;


public class RetailStore {
	private String storeName = null;
	   public RetailStore(String storeName){
		   this.storeName = storeName;
	   }
	   
	   public String DB_URL = "jdbc:mysql://localhost:3306/spencerhome";
	   public String user = "root";
	   public String pass = "root";
	   
	   //For insert Auto Incremented Products
	   public Integer nextProductPk() throws Exception{
		   Connection conn = null;
		   int pk = 0;
		   try{
			   conn = DataSource.getConnection();
			   PreparedStatement pstm = conn.prepareStatement("Select max(productId) from products");
			   ResultSet rs = pstm.executeQuery();
			   while(rs.next()){
				   pk = rs.getInt(1);
			   }
			   rs.close();
		   }catch(Exception e){
			   e.printStackTrace();
		   }finally{
			   DataSource.closeConnection(conn);
		   }
		   
		   return pk+1;
	   }
	   
	   //for Insert Auto Incremented Customers
	   public Integer nextCustomerPk() throws Exception{
		   Connection conn = null;
		   int pk = 0;
		   try{
			   conn = DataSource.getConnection();
			   PreparedStatement pstm = conn.prepareStatement("Select max(customerId) from customers");
			   ResultSet rs = pstm.executeQuery();
			   while(rs.next()){
				   pk = rs.getInt(1);
			   }
			   rs.close();
		   }catch(Exception e){
			   e.printStackTrace();
		   }finally{
			   DataSource.closeConnection(conn);
		   }
		   
		   return pk+1;
	   }
	   
	   
	   //TO add customers Details into database
	   public void addCustomer(String fname,String lname,String gender,int contactNumber) throws Exception{
		   Connection conn = null;
		   PreparedStatement  pst = null;
		   int pk = 0;
		   try{
			   Customer c  = new Customer();
			   c.setFname(fname);
			   c.setLname(lname);
			   c.setGender(gender);
			   c.setContactNumber(contactNumber);
			   
			   conn = DataSource.getConnection();
			   pk = nextCustomerPk();
			   //conn.setAutoCommit(false);
			   String sql = "insert into customers values(?,?,?,?,?)";
			   pst = conn.prepareStatement(sql);
			   
		
			   pst.setInt(1, pk);
			   pst.setString(2, c.getFname().trim());
			   pst.setString(3, c.getLname().trim());
			   pst.setString(4,c.getGender().trim());
			   pst.setInt(5, c.getContactNumber());
		       
			   int i = pst.executeUpdate();
			   //conn.commit();
			   System.out.println(i+"..Record Inserted");
			   
		   }catch(Exception e){
			   System.out.println(e);
			   try{
				   
			   }catch(Exception e1){
				   e1.printStackTrace();
			   }
		   }finally{
			   try{
				   DataSource.closeConnection(conn);
				   
			   }catch(Exception e){
				   System.out.println(e);
			   }
		   }
	   }
	   
	   
	   //to add products in Databases
	   public void addProduct(String productName , String status ,double price) throws Exception{
		   Connection conn = null;
		   PreparedStatement  pst = null;
		   int pk = 0;
		   try{
			   Product p = new Product();
			   p.setProductName(productName);
			   p.setStatus(status);
			   p.setPrice(price);
			   
			   conn = DataSource.getConnection();
			   pk = nextProductPk();
			   conn.setAutoCommit(false);
			   String sql = "insert into products values(?,?,?,?);";
			   pst = conn.prepareStatement(sql);
			   pst.setInt(1, pk);
		       pst.setString(2, p.getProductName().toUpperCase().trim());
		       pst.setDouble(3, p.getPrice());
		       pst.setString(4, p.getStatus().toUpperCase().trim());
		       
			   int i = pst.executeUpdate();
			   conn.commit();
			   System.out.println(i+"..Record Inserted");
			   
		   }catch(Exception e){
			   System.out.println(e);
			   try{
				   conn.rollback();
			   }catch(Exception e1){
				   e1.printStackTrace();
			   }
		   }finally{
			   try{
				   DataSource.closeConnection(conn);
				   
				   if(pst != null){
					   pst.close();
				   }
				   
			   }catch(Exception e){
				   System.out.println(e);
			   }
		   }
	   }
	   
	   //to check product avalaibility in Store
	   public void checkProductAvailability(String productName) throws Exception{
		   Connection conn = null;
		   PreparedStatement pst = null;
		   ResultSet rs = null;
		   int count = 0;
		   try{
			   Product p = new Product();
			   p.setProductName(productName);
			   conn = DataSource.getConnection();
			   conn.setAutoCommit(false);
			   String sql = "select count(productname) from products  where productname = '"+p.getProductName().toUpperCase()+"' group by status having status = 'AVAILABLE'";
			   pst = conn.prepareStatement(sql);
			   rs = pst.executeQuery();
			   conn.commit();
			   while(rs.next()){
				  count =  rs.getInt(1);
			   }
			   System.out.println("Available product : "+count);
		   }catch(Exception e){
			   System.out.println(e);
			   try{
				   conn.rollback();
			   }catch(Exception e1){
				   e.printStackTrace();
			   }
		   }finally{
			   try{
				   DataSource.closeConnection(conn);
				   if(pst != null){
					   pst.close();
				   }
				   if(rs!= null){
					   rs.close();
				   }
				   
			   }catch(Exception e){
				   System.out.println(e);
			   }   
		   }
	   }
	   
	   //Display All the the products from the store
	   public void display(){
		   Connection conn = null;
		   PreparedStatement pst = null;
		   ResultSet rs = null;
		   try{
			   conn = DataSource.getConnection();
			   conn.setAutoCommit(false);
			   String sql = "Select * from products where status = 'AVAILABLE'";
			   pst = conn.prepareStatement(sql);
			   rs = pst.executeQuery();
			   conn.commit();
			   while(rs.next()){
				   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
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
				   DataSource.closeConnection(conn);
				   if(pst != null){
					   pst.close();
				   }
				   if(rs!= null){
					   rs.close();
				   }
				   
			   }catch(Exception e){
				   System.out.println(e);
			   }   
		   }
	   }
	   
	   //Book Products from Store
	   public void bookProduct(int customerId,String productName,int numberOfProducts){
		   Connection conn = null;
		   PreparedStatement pst = null;
		   PreparedStatement pst2 = null;
		   PreparedStatement pst3 = null;
		   PreparedStatement pst4 = null;
		   ResultSet rs = null;
		   ResultSet rs2 = null;
		   double price = 0.0;
		   int count = 0;
		   try{
			   Product p = new Product();
			   Customer c = new Customer();
			   conn = DataSource.getConnection();
			   String sql = "select productprice,productname from products where productname = '"+productName.toUpperCase()+"' and status = 'AVAILABLE' ";
			   String sql2 = "select count(productname) from products  where productname = '"+productName.toUpperCase()+"' group by status having status = 'AVAILABLE'";
			   
			   pst = conn.prepareStatement(sql);
			   rs = pst.executeQuery();
			   pst2 = conn.prepareStatement(sql2);
			   rs2 = pst2.executeQuery();
			   
			   while(rs2.next()){
				   count = rs2.getInt(1);
			   }
			   while(rs.next()){
				   if(productName.toUpperCase().equals(rs.getString(2)) && count>=numberOfProducts){
					   price = rs.getDouble(1);
				   }else{
					   System.out.println("Products or Number  of Products  are  Not Available in Store");
					   break;
				   }
				   
			   }
			   
			   //for insert values in booklist
			   if(count >=numberOfProducts){
			   String sql3 = "insert into bookList values(?,?,?,?)";
			   pst3 = conn.prepareStatement(sql3);
			   
			   pst3.setInt(1, customerId );
			   pst3.setString(2,productName );
			   pst3.setInt(3, numberOfProducts);
			   pst3.setDouble(4,(price*numberOfProducts));
			   int i = pst3.executeUpdate();
			   //if(i>=1){
			   //System.out.println("Record Inserted in booklist");
			   //}
			   
			   //And also update booked record details from product table and make status unavailable
			   String sql4 = "delete from products where productname = ? order by productname limit ?";
			   pst4 = conn.prepareStatement(sql4);
			   
			   pst4.setString(1, productName);
			   pst4.setInt(2, numberOfProducts);
			   int j = pst4.executeUpdate();
			   //if(j>=1){
				//   System.out.println("Record Also Updated in Products Table");
			   //}
			   System.out.println("Products are Booked");
			   }
			   //query for user
		   }catch(Exception e){
			   System.out.println(e);
		   }finally{
			   try{
				   conn.close();
				   pst.close();
				   pst2.close();
				   pst3.close();
				   pst4.close();
				   rs.close();
				   rs2.close();
			   }catch(Exception e){
				   
			   }
			   
		   }
	   }
	   
	   //calculate net Ammount for perticular custmoer
	   public void calculateNetAmount(int customerId,double discount){
		   Connection conn = null;
		   PreparedStatement pst = null;
		   PreparedStatement pst2 = null;
		   ResultSet rs = null;
		   ResultSet rs2 = null;
		   
		   int custId = 0;
		   String custName = null;
		   double totalAmount = 0.0;
		   try{
			   conn = DataSource.getConnection();
			   conn.setAutoCommit(false);
			  
			   String sql = "select customerId, firstname from customers where customerId = '"+customerId+"'";
			   pst = conn.prepareStatement(sql);
			   rs = pst.executeQuery();
			   conn.commit();
			    while(rs.next()){
			    	custId = rs.getInt(1);
			    	custName = rs.getString(2);
			    }
			  
			   
			   // select record from booklist
			   String sql2 = "select sum(productprice) from booklist where customerID = '"+customerId+"'";
			   pst2 = conn.prepareStatement(sql2);
			   rs2 = pst2.executeQuery();
			   conn.commit();
			   while(rs2.next()){
				  totalAmount = rs2.getDouble(1); 
			   }
			   if(custId == customerId){
			   System.out.println(custName + ": YOUR TOTAL AMOUNT IS := "+(totalAmount-discount));
			   }else{
				   System.out.println("Sorry User Not Exists");
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
				   DataSource.closeConnection(conn);
				   pst.close();
				   pst2.close();
				   rs.close();
				   rs2.close();
			   }catch(Exception e){
				   System.out.println(e);
			   }
		   }
	   }
}

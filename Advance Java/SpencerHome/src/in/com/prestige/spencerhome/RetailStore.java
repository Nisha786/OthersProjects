package in.com.prestige.spencerhome;
import java.sql.*;



public class RetailStore {
   private String storeName = null;
   public RetailStore(String storeName){
	   this.storeName = storeName;
   }
   
   public String DB_URL = "jdbc:mysql://localhost:3306/spencerhome";
   public String user = "root";
   public String pass = "root";
   
   //TO add customers Details into database
   public void addCustomer(String fname,String lname,String gender,int contactNumber) throws Exception{
	   Connection conn = null;
	   PreparedStatement  pst = null;
	   try{
		   Customer c  = new Customer();
		   c.setFname(fname);
		   c.setLname(lname);
		   c.setGender(gender);
		   c.setContactNumber(contactNumber);
		   
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection(DB_URL,user,pass);
		   String sql = "insert into customers(firstname,lastname,gender,mobilenumber)"+ "values(?,?,?,?)";
		   pst = conn.prepareStatement(sql);
		   
	
		   pst.setString(1, c.getFname().trim());
		   pst.setString(2, c.getLname().trim());
		   pst.setString(3,c.getGender().trim());
		   pst.setInt(4, c.getContactNumber());
	       
		   int i = pst.executeUpdate();
		   System.out.println(i+"..Record Inserted");
		   
	   }catch(Exception e){
		   System.out.println(e);
	   }finally{
		   try{
			   if(conn != null){
				   conn.close();
			   }
			   if(pst != null){
				   pst.close();
			   }
			   
		   }catch(Exception e){
			   System.out.println(e);
		   }
	   }
   }
   
   
   //to add products in Databases
   public void addProduct(String productName , String status ,double price) throws Exception{
	   Connection conn = null;
	   PreparedStatement  pst = null;
	   try{
		   Product p = new Product();
		   p.setProductName(productName);
		   p.setStatus(status);
		   p.setPrice(price);
		   
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection(DB_URL,user,pass);
		   String sql = "insert into products(productname,productprice,status)"+ "values(?,?,?);";
		   pst = conn.prepareStatement(sql);
		   
	       pst.setString(1, p.getProductName().toUpperCase().trim());
	       pst.setDouble(2, p.getPrice());
	       pst.setString(3, p.getStatus().toUpperCase().trim());
	       
		   int i = pst.executeUpdate();
		   System.out.println(i+"..Record Inserted");
		   
	   }catch(Exception e){
		   System.out.println(e);
	   }finally{
		   try{
			   if(conn != null){
				   conn.close();
			   }
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
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection(DB_URL,user,pass);
		   String sql = "select count(productname) from products  where productname = '"+p.getProductName().toUpperCase()+"' group by status having status = 'AVAILABLE'";
		   pst = conn.prepareStatement(sql);
		   rs = pst.executeQuery();
		   while(rs.next()){
			  count =  rs.getInt(1);
		   }
		   System.out.println("Available product : "+count);
	   }catch(Exception e){
		   System.out.println(e);
	   }finally{
		   try{
			   if(conn != null){
				   conn.close();
			   }
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
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection(DB_URL,user,pass);
		   String sql = "Select * from products where status = 'AVAILABLE'";
		   pst = conn.prepareStatement(sql);
		   rs = pst.executeQuery();
		   while(rs.next()){
			   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
		   }
	   }catch(Exception e){
		   System.out.println(e);
	   }finally{
		   try{
			   if(conn != null){
				   conn.close();
			   }
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
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection(DB_URL,user,pass);
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
				   
				   price = price+rs.getDouble(1);
				   
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
		   pst3.setDouble(4,price);
		   int i = pst3.executeUpdate();
		   //if(i>=1){
		   //System.out.println("Record Inserted in booklist");
		   //}
		   
		   //And also update booked record details from product table and make status unavailable
		   String sql4 = "update products set status = ?  order by productname limit ? ";
		   pst4 = conn.prepareStatement(sql4);
		   pst4.setString(1, "UN-AVAILABLE");
		   //pst4.setString(2, productName);
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
		   Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection(DB_URL,user,pass);
		  
		   String sql = "select customerId, firstname from customers where customerId = ?";
		   pst = conn.prepareStatement(sql);
		   pst.setInt(1, customerId);
		   rs = pst.executeQuery();
		    while(rs.next()){
		    	custId = rs.getInt(1);
		    	custName = rs.getString(2);
		    }
		  
		   
		   // select record from booklist
		   String sql2 = "select sum(productprice) from booklist where customerID = ?";
		   pst2 = conn.prepareStatement(sql2);
		   pst2.setInt(1, customerId);
		   rs2 = pst2.executeQuery();
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
	   }finally{
		   try{
			   conn.close();
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

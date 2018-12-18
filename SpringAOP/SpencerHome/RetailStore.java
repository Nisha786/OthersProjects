import java.io.*;
import java.util.*;
class RetailStore{
	
	ArrayList list = new ArrayList();
	ArrayList listCust = new ArrayList();
    String storeName = null;
    int customerId = 0;
    int productId = 0;
    //int productCount =0;
    double totalNetAmount = 0.0;
    int numberBooked;
	 public RetailStore(String storeName){
      this.storeName = storeName;
	 }

	 public int generateCustomerId() throws Exception{
         	customerId++;
         	return customerId;
	 }

	 public int generateProductID() throws Exception{
          productId++;
          return productId;
	 }

	 //public int getProductCount() throws Exception{
       //    productCount++;
     //      return productCount;
	// } 


//for add a customer details into a file
	 public void addCustomer(String name,int contactNo) throws Exception {

	 	ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream("F:/Prestige Java/SpencerHome/CustomerList.txt"));
	 	generateCustomerId();
	 	Customer c = new Customer();
	 	c.setCustomerID(customerId);
	 	c.setName(name);
	 	c.setContactNo(contactNo);
	 	listCust.add(c);
	 	bw.writeObject(listCust);
        FileInputStream  fout = new FileInputStream("F:/Prestige Java/SpencerHome/CustomerList.txt");
		ObjectInputStream read = new ObjectInputStream(fout);
		ArrayList emplist =  (ArrayList)read.readObject();
		Iterator it = emplist.iterator();
		while(it.hasNext()){
			Customer emp = (Customer)it.next();
			System.out.println(emp.getCustomerID()+"------"+emp.getName()+"-------"+emp.getContactNo());
		}
	 }


//Add PRoduct Details into a file
	 public void addProduct(String name,String status,double price) throws Exception{
	 	ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("F:/Prestige Java/SpencerHome/ProductList.txt"));
	 	generateProductID();
	 	Product p = new Product();
	 	//Customer c = new Customer();
	 	//p = c;
	 	p. setProductID(productId);
	 	p. setProductName(name);
	 	p.setProductPrice(price);
	 	p.setStatus(status);
	 	list.add(p);
	 	write.writeObject(list);
        FileInputStream  fout = new FileInputStream("F:/Prestige Java/SpencerHome/ProductList.txt");
		ObjectInputStream read = new ObjectInputStream(fout);
		ArrayList emplist =  (ArrayList)read.readObject();
		Iterator it = emplist.iterator();
		while(it.hasNext()){
			Product pro = (Product)it.next();
			System.out.println(pro.getProductID()+"------"+pro.getProductName()+"-------"+pro.getProductPrice()+"------"+pro.getStatus());
		}
	 }

//Check Product Availability
	 public void checkProductAvailability(String ProductName) throws Exception{
	 	int productCount = 0;
	 	FileInputStream  fout = new FileInputStream("F:/Prestige Java/SpencerHome/ProductList.txt");
		ObjectInputStream read = new ObjectInputStream(fout);
		Product p = new Product();
		ArrayList emplist =  (ArrayList)read.readObject();
		Iterator it = emplist.iterator();
		
		while(it.hasNext()){
			Product emp = (Product)it.next();
			if(ProductName.equals(emp.getProductName()) && emp.getStatus().equals("Available")){
                  productCount++;
			}
		}
             System.out.println("available product = "+productCount);
	 }
   

   //Add Booked product List Into a file for a particular Customer
    public int bookProduct(int CustomerID,String ProductName, int NumberOfProduct) throws Exception{
    	 numberBooked = NumberOfProduct;
         FileInputStream  fout = new FileInputStream("F:/Prestige Java/SpencerHome/ProductList.txt");
         ObjectInputStream read = new ObjectInputStream(fout);
         FileInputStream  fout1 = new FileInputStream("F:/Prestige Java/SpencerHome/CustomerList.txt");
         ObjectInputStream read1 = new ObjectInputStream(fout1);

         Product p = new Product();
         Customer c = new Customer();

         String nameOfCustomer = null;
         ArrayList productList =  (ArrayList)read.readObject();
         ArrayList customerList =  (ArrayList)read1.readObject();

         Iterator itp = productList.iterator();
         Iterator itc = customerList.iterator();

         int countProduct = 0;
         while (itc.hasNext()) {
         	Customer cust = (Customer)itc.next();
         	if(CustomerID == cust.getCustomerID()){
  				nameOfCustomer = cust.getName();
         	}
         }
         while(itp.hasNext()){
         	Product emp = (Product)itp.next();
            if(ProductName.equals(emp.getProductName()) && emp.getStatus().equals("Available")){
			     ObjectOutputStream writeList = new ObjectOutputStream(new FileOutputStream("F:/Prestige Java/SpencerHome/BookedProductList.txt"));
				 p.setProductName(ProductName);
				 p.setProductPrice(emp.getProductPrice());
				 p.setCustmerBookID(CustomerID);
				 //p.productId(emp.getProductID());
                 list.add(p);
                 writeList.writeObject(list);
            	 countProduct ++;   //for counting how many products are booked by a customer
				 
			}
         	if(ProductName.equals(emp.getProductName()) && emp.getStatus().equals("Available") && countProduct>=NumberOfProduct){
                   System.out.print(emp.getProductName()+" =  you Booked : "+NumberOfProduct + ": and Booked by : "+nameOfCustomer);
                     break;
    			}
         }

           return 1;
    }


//calculate total Amount for every customer
    public void calculateNetAmount(int customerID,double discount) throws Exception{
         String nameOfCustomer = null;
         FileInputStream  fout1 = new FileInputStream("F:/Prestige Java/SpencerHome/BookedProductList.txt");
         ObjectInputStream read1 = new ObjectInputStream(fout1);


         //code for knowing about the customer related tp thier CostomerID
         FileInputStream  fout = new FileInputStream("F:/Prestige Java/SpencerHome/CustomerList.txt");
         ObjectInputStream read = new ObjectInputStream(fout);
         Customer c = new Customer();
         ArrayList customerList =  (ArrayList)read.readObject();
         Iterator itc = customerList.iterator();
         while (itc.hasNext()) {
         	Customer cust = (Customer)itc.next();
         	if(customerID == cust.getCustomerID()){
  				nameOfCustomer = cust.getName();
         	}
         }

        
         //code for get PriceList of all The booked Products then Counting Total
          Product p = new Product();
          ArrayList bookedList =  (ArrayList)read1.readObject();
          Iterator itBooked = bookedList.iterator();
           while (itBooked.hasNext()) {
         	Product pro = (Product)itBooked.next();
         	if(customerID == pro. getCustmerBookID()){
           		 totalNetAmount = totalNetAmount+pro.getProductPrice();
         		 System.out.println(nameOfCustomer +" = Booked : "+pro.getProductName() +" : Your Total Ammount is : "+(totalNetAmount-discount));
           	}
         }
         totalNetAmount = 0;
    }

    public void display() throws Exception{
           Product p = new Product();
           FileInputStream  fout = new FileInputStream("F:/Prestige Java/SpencerHome/ProductList.txt");
		   ObjectInputStream read = new ObjectInputStream(fout);
		   ArrayList emplist =  (ArrayList)read.readObject();
		   Iterator it = emplist.iterator();
		   while(it.hasNext()){
			Product emp = (Product)it.next();
			System.out.println(emp.getProductID()+"------"+emp.getProductName()+"-------"+emp.getProductPrice()+"------"+emp.getStatus());
		
		}
    }
}
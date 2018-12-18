package in.com.prestige.spencer;
import java.io.*;



public class RetailStoreTest {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		RetailStore StoreObj = new RetailStore("RetailStore");
		 int ch;
		  
		 do{
             
			System.out.println("\t\t\tEnter the choice:");
			System.out.println("\n\t1.to Add Customer\n\t 2.Add product\n\t3.Check Product Availability"
					+ "\n\t4.Display\n\t5.Book Product\n\t6.Calculate Net Amount\n\t7.Exit");			
		    ch=Integer.parseInt(br.readLine());
			switch(ch)
			{
				case 1:	System.out.println("------customer Addition-------");
						System.out.println("Enter the First name of customer:");
						String firstName = br.readLine();
						System.out.println("Enter the Last name of customer:");
						String lastName = br.readLine();
						System.out.println("Enter the Gender of customer:");
						String gender = br.readLine();
						System.out.println("enter the contact number");
						int contactNumber = Integer.parseInt(br.readLine());
						StoreObj.addCustomer(firstName,lastName,gender,contactNumber);
						break;
				
				case 2:		
				        System.out.println("------product Addition-------");
						System.out.println("Enter product name:");
						String productName =br.readLine();
						System.out.println("Enter the price of product:");
						double price=Double.parseDouble(br.readLine());
						System.out.println("enter the status");
						String status = br.readLine();
						
						StoreObj.addProduct(productName,status, price);
					
						break;
						
				case 3:		
				        System.out.println("------check Availability-------");
						System.out.println("Enter the product name:");
						String productNameAvail =br.readLine();
						StoreObj.checkProductAvailability(productNameAvail);
						//System.out.println("available product="+numberOfProduct);
						break;
				case 4:		
				        System.out.println("------Display-------");
						StoreObj.display();
						break;
				case 5:		
				        System.out.println("------booked Product-------");
						System.out.println("Enter the customer id:");
						int customerIdForBook =Integer.parseInt(br.readLine());
						System.out.println("enter the product name");
						String bookProductName =br.readLine();
						System.out.println("Enter the number of products:");
						int bookProductCount =Integer.parseInt(br.readLine());
						StoreObj.bookProduct(customerIdForBook, bookProductName, bookProductCount);
						break;
				case 6:		
				        System.out.println("------calculate cost-------");
						System.out.println("Enter the customerID id:");
						int CustomerIdForBill =Integer.parseInt(br.readLine());
						System.out.println("Enter the discount:");
						double discount=Double.parseDouble(br.readLine());
						
						StoreObj.calculateNetAmount(CustomerIdForBill, discount);
						//System.out.println("Total Cost = "+ cost);
						break;
			
				case 7:		
				        System.out.println("Sorry");
						break;
						
				default:System.out.println("Invalid option!!");	
	 	
	         }
		 }while(ch!=7);
	}
}

package in.com.prestige.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import in.com.prestige.bean.CustomerBean;
import in.com.prestige.bean.ProductBean;
import in.com.prestige.model.CustomerModel;
import in.com.prestige.model.ProductsModel;

public class TestSpencer {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		CustomerModel cust = new CustomerModel();
		CustomerBean custbean = new CustomerBean();
		ProductBean proBean = new ProductBean();
		ProductsModel pro = new ProductsModel();
		int i;
		int count = 0;
		do {
			System.out.println("\t\t\tEnter the choice:");
			System.out.println("\n\t1.to Add Customer\n\t 2.Add product\n\t3.Check Product Availability"
					+ "\n\t4.Display\n\t5.Book Product\n\t6.Calculate Net Amount\n\t7.Exit");
			i = Integer.parseInt(br.readLine());

			switch (i) {
			case 1:
				System.out.println("------customer Addition-------");
				System.out.println("Enter the  name of customer:");
				String firstName = br.readLine();
				System.out.println("Enter the Address of customer:");
				String address = br.readLine();
				System.out.println("enter the contact number");
				String contactNumber = br.readLine();
				custbean.setName(firstName);
				custbean.setAddress(address);
				custbean.setContactNo(contactNumber);
				cust.addCustomers(custbean);
				//StoreObj.addCustomer(firstName, gender, contactNumber);
				break;

			case 2:
				/*System.out.println("------product Addition-------");
				System.out.println("Enter product name:");
				String productName = br.readLine();
				System.out.println("Enter the price of product:");
				double price = Double.parseDouble(br.readLine());
				System.out.println("enter the status");
				String status = br.readLine();
				System.out.println("Enter the Number of product:");
				double number = Integer.parseInt(br.readLine());*/
				for(int c :pro.addProducts()){
					++count;
			    	System.out.println("Record inserted : "+count);
				}

				break;

			case 3:
				System.out.println("------check Availability-------");
				System.out.println("Enter the product name:");
				String productNameAvail = br.readLine();
				//StoreObj.checkProductAvailability(productNameAvail);
				// System.out.println("available product="+numberOfProduct);
				break;
			case 4:
				System.out.println("------Display-------");
				cust.getCustomers();
				break;
			case 5:
				System.out.println("------booked Product-------");
				System.out.println("Enter the customer id:");
				int customerIdForBook = Integer.parseInt(br.readLine());
				System.out.println("enter the product name");
				String bookProductName = br.readLine();
				System.out.println("Enter the number of products:");
				int bookProductCount = Integer.parseInt(br.readLine());
				//StoreObj.bookProduct(customerIdForBook, bookProductName, bookProductCount);
				break;
			case 6:
				System.out.println("------calculate cost-------");
				System.out.println("Enter the customerID id:");
				int CustomerIdForBill = Integer.parseInt(br.readLine());
				System.out.println("Enter the discount:");
				double discount = Double.parseDouble(br.readLine());

				//StoreObj.calculateNetAmount(CustomerIdForBill, discount);
				// System.out.println("Total Cost = "+ cost);
				break;

			case 7:
				System.out.println("Sorry");
				break;

			default:
				System.out.println("Invalid option!!");

			}
		} while (i != 7);
	}
}

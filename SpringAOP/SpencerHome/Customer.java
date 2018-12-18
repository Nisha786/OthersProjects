import java.io.*;
import java.util.*;
class Customer implements Serializable{

	private int customerID;
	private String name;
	private int contactNo;
	/*public Customer (int customerID,String name,int contactNo){
		this.customerID = customerID;
		this.name  = name;
		this.contactNo = contactNo;
	}*/

	public int  getCustomerID(){
		return customerID;
	}
	public String getName(){
		return name;
	}
	public int getContactNo(){
		return contactNo;
	}

	public void setCustomerID(int customerID){
       this.customerID = customerID;
	}
	public void setName(String name){
       this.name = name;
	}
    
    public void  setContactNo(int contactNo){
		this.contactNo = contactNo;
	}
	//method for detals of booking of an Customer
	//Public void addBookedProduct(Product obj){
         
	//}
}
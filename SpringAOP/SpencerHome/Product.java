import java.io.*;
import java.util.*;
class Product  implements Serializable{
	int productID;
	String productName;
	double ProductPrice;
	String status;
	int customerBookID;
	/*Product (int productID,String productName, double ProductPrice){
           this.productName = productName;
           this.productID = productID;
           this.ProductPrice = ProductPrice;
	} */

    public String getStatus(){
    	return status;
    }

    public void setStatus(String status){
    	this.status = status;
    }

	public int getProductID(){
		return productID;
	}

	public String getProductName(){
		return productName;
	}

	public double getProductPrice(){
		return ProductPrice;
	}

	public void setProductID(int productID){
         this.productID = productID;
	} 
	public void setProductName(String productName){
		this.productName = productName;
	}

	public void setProductPrice(double ProductPrice){
		this.ProductPrice = ProductPrice;
	}
    
    public void setCustmerBookID(int customerBookID){
       this.customerBookID = customerBookID;
    }

    public int getCustmerBookID(){
    	return customerBookID;
    }

}
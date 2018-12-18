package in.com.prestige.bean;

import java.io.InputStream;



public class ProductsBean {
   private String productname;
   private String status ;
   private double price;
   private int productID;
   private String category;
   private int numberofproducts;
   private String filename;
   private String path;
   
   
   
   
   public int getNumberofproducts() {
	return numberofproducts;
}
public void setNumberofproducts(int numberofproducts) {
	this.numberofproducts = numberofproducts;
}

public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public void setCategory(String category){
	   this.category = category;
   }
   public String getCategory(){
	   return category;
   } 
   
   public void setProductName(String productname){
	   this.productname = productname;
   }
   public String getProductName(){
	   return productname;
   }
   
   public void setStatus(String status){
	   this.status = status;
   }
   public String getStatus(){
	   return status;
   }
   
   public void setPrice(double price){
	   this.price = price;
   }
   public double getPrice(){
	   return price;
   }
   
   public void setProductId(int productID){
	  this.productID = productID;
   }
   public int  getProductID(){
	   return productID;
   }
}

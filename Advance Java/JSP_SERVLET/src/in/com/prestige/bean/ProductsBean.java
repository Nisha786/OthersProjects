package in.com.prestige.bean;

public class ProductsBean {
   private String productname;
   private String status ;
   private double price;
   private int productID;
   
   
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

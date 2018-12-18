package in.com.prestige.bean;

public class StudentBean {
    private String name;
    private String gender;
    private String address;
    private int contactno;
    
    public void setName(String name){
    	this.name  = name;
    }
    public String getName(){
    	return name;
    }
    
    public void setGender(String gender){
    	this.gender = gender;
    }
    public String getGender(){
    	return gender;
    }
    
    public void setAddress(String address){
    	this.address = address;
    }
    public String getAddress(){
    	return address;
    }
    
    public void setContactNo(int contactno){
    	this.contactno = contactno;
    }
    
    public int getContactNo(){
    	return contactno;
    }
}

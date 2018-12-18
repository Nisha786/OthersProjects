package in.com.prestige.dto;

import java.util.Set;

public class VendorDTO {
    private Integer vendorID;
    private String vendorName;
    public Integer getVendorID() {
		return vendorID;
	}
	public void setVendorID(Integer vendorID) {
		this.vendorID = vendorID;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Set getChildren() {
		return children;
	}
	public void setChildren(Set children) {
		this.children = children;
	}
	private Set children;
    		
}

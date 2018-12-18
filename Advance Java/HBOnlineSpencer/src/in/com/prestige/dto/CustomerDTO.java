package in.com.prestige.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int customersID = 0;

	private String name = null;
	private String email = null;
	private String password = null;
	private String contactno = null;

	public int getCustomersID() {
		return customersID;
	}

	public void setCustomersID(int customersID) {
		this.customersID = customersID;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

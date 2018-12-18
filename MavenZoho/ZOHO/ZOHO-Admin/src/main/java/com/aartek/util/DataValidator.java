package com.aartek.util;

import org.springframework.stereotype.Component;

@Component
public class DataValidator {

	// For Email Check
	public boolean isEmail(String val) {
		String emailreg = "^[a-zA-Zs][a-zA-Z0-9]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if (val != null) {
			return val.matches(emailreg);
		} else {
			return false;
		}
	}

	// For FirstName Check
	public boolean isFirstName(String val) {
		String name = "^[a-zA-Z]{2,}$";
		if (val != null) {
			return val.matches(name);
		} else {
			return false;
		}
	}

	// For Last name Check
	public boolean isLastName(String val) {
		String name = "^[a-zA-Z]{2,}$";
		if (val != null) {
			return val.matches(name);
		} else {
			return false;
		}
	}

	// For Mobile Number
	public boolean isMobileNo(String val) {
		String mobileRegex = "\\d{10}";
		if (val.matches(mobileRegex)) {
			return true;
		} else
			return false;
	}

	// for Password
	public boolean isPassword(String val) {
		if (val.length() >= 6 && val.length() <= 12) {
			return true;
		} else {
			return false;
		}
	}

	// For Price Check in double
	public boolean isPrice(String val) {
		String priceRegex = "[0-9]+([,.][0-9]{1,2})?";
		if (val.matches(priceRegex)) {
			return true;
		} else {
			return false;
		}

	}

	// For IIbtegr value between 0 to 100
	public boolean isNumber(String val) {
		String numberRegex = "\\d+";
		if (val.matches(numberRegex)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isVarchar(String val){
		String var="^[a-zA-Z0-9_ ]*$";
		if (val.matches(var)) {
			return true;
		} else {
			return false;
		}
	}
}

package com.aartek.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.User;

@Component
public class RegistrationValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors error) {
		ValidationUtils.rejectIfEmpty(error,"email", null,"Please Enter Email");
		ValidationUtils.rejectIfEmpty(error,"password", null,"Please Enter Password");
		ValidationUtils.rejectIfEmpty(error,"firstName", null,"Please Enter FirstName");
		ValidationUtils.rejectIfEmpty(error,"lastname", null,"Please Enter LastName");
		ValidationUtils.rejectIfEmpty(error,"contactNo", null,"Please Enter ContactNo");
	}
 
}

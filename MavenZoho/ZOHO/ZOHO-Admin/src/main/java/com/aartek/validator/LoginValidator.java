package com.aartek.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;

@Component
public class LoginValidator implements Validator {
	@Autowired
	private LoginRepository loginRepo;

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "email","error.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "password","error.password.empty");
		
		if(user.getEmail()!=null  && user.getEmail().trim().length()>0){
			String check = loginRepo.checkLogin(user);
			if(check.equals("User InValid")){
				errors.rejectValue("email","warn.email.invalid");
			}
		}
	}

}

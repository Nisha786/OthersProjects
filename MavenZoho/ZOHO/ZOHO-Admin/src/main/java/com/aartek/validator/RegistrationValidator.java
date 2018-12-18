package com.aartek.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.User;
import com.aartek.repository.RegistrationRepository;
import com.aartek.util.DataValidator;

@Component
public class RegistrationValidator implements Validator {

	@Autowired
	private DataValidator dataValidator;
	@Autowired
	private RegistrationRepository resRepository;

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "email", "error.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.firstname.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.lastname.empty");
		ValidationUtils.rejectIfEmpty(errors, "contactNo", "error.contact.empty");

		// Check for Business Rules Validations
		if (user.getFirstName() != null && user.getFirstName().trim().length() > 0) {
			if (!dataValidator.isFirstName(user.getFirstName())) {
				errors.rejectValue("firstName","error.firstname.rule");
			}
		}
		if (user.getLastName() != null && user.getLastName().trim().length() > 0) {
			if (!dataValidator.isLastName(user.getLastName())) {
				errors.rejectValue("lastName","error.lastname.rule");
			}
		}
		if (user.getEmail() != null && user.getEmail().trim().length() > 0) {
			if (!dataValidator.isEmail(user.getEmail())) {
				errors.rejectValue("email","error.email.rule");
			} else {
				String checkMail = resRepository.checkEmailIfExits(user.getEmail());
				System.out.println(checkMail);
				if (checkMail != null) {
					errors.rejectValue("email","warn.email.rule");
				}
			}
		}
		if (user.getPassword() != null && user.getPassword().trim().length() > 0) {
			if (!dataValidator.isPassword(user.getPassword())) {
				errors.rejectValue("password","error.password.rule");
			}
		}
		if (user.getContactNo() != null && user.getContactNo().trim().length() > 0) {
			if (!dataValidator.isMobileNo(user.getContactNo())) {
				errors.rejectValue("contactNo","error.contact.rule");
			}
		}
	}

}

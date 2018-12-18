package com.aartek.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.Products;

@Component
public class ProductValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Products.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors error) {
		ValidationUtils.rejectIfEmpty(error,"productName", null,"Please Enter Productname");
		ValidationUtils.rejectIfEmpty(error,"description", null,"Please Enter Description");
		ValidationUtils.rejectIfEmpty(error,"price", null,"Please Enter Price");
		ValidationUtils.rejectIfEmpty(error,"noOfProducts", null,"Please Enter Numbers");
	}
 
}

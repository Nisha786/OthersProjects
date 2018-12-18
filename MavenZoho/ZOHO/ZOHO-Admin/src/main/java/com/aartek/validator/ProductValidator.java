package com.aartek.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.aartek.model2.Products;
import com.aartek.util.DataValidator;

@Component
public class ProductValidator implements Validator {
	@Autowired
	private DataValidator dataValidator;

	public boolean supports(Class<?> clazz) {
		return Products.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Products product = (Products) target;
		ValidationUtils.rejectIfEmpty(errors, "productname", "error.productname.empty");
		ValidationUtils.rejectIfEmpty(errors, "productDescription", "error.productDescription.empty");
		ValidationUtils.rejectIfEmpty(errors, "price", "error.price.empty");
		ValidationUtils.rejectIfEmpty(errors, "numberOfProducts", "error.numberOfProducts.empty");

		// Check Business Rule For Image File
		MultipartFile file = (MultipartFile) product.getImagefile();
		if (file.isEmpty()) {
			errors.rejectValue("imagefile", "error.image.empty");
		}
		if (!file.isEmpty()) {
			if (!(file.getContentType().toLowerCase().equals("image/jpg")
					|| file.getContentType().toLowerCase().equals("image/jpeg")
					|| file.getContentType().toLowerCase().equals("image/png"))) {
				errors.rejectValue("imagefile", "error.image.rule");
			}

		}

		// Checks For business Rule
		if (product.getProductname() != null && product.getProductname().trim().length() > 0) {
			if (!dataValidator.isVarchar(product.getProductname())) {
				errors.rejectValue("productname", "error.productname.rule");
			}
		}
		if (product.getProductDescription() != null && product.getProductDescription().trim().length() > 0) {
			if (!dataValidator.isFirstName(product.getProductDescription())) {
				errors.rejectValue("productDescription", "error.productDescription.rule");
			}
		}
		if (product.getPrice() != null && product.getPrice().trim().length() > 0) {
			if (!dataValidator.isPrice(product.getPrice())) {
				errors.rejectValue("price", "error.price.rule");
			}
		}
		if (product.getNumberOfProducts() != null && product.getNumberOfProducts().trim().length() > 0) {
			if (!dataValidator.isNumber(product.getNumberOfProducts())) {
				errors.rejectValue("numberOfProducts", "error.numberOfProducts.rule");
			}
		}
	}

}

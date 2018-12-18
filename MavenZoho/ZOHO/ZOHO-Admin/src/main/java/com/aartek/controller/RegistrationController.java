package com.aartek.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.User;
import com.aartek.service.RegistrationService;
import com.aartek.validator.RegistrationValidator;



@Controller
public class RegistrationController {
	@Autowired
	private RegistrationService registerService;
	@Autowired
	private RegistrationValidator regValidator;

	/*
	 * @RequestMapping("/registration") public String
	 * showRegistration(Map<String, Object> map) {
	 * System.out.println("Show Registration"); map.put("userRegistrationMap",
	 * new User()); return "signUp"; }
	 */

	@RequestMapping(value = "/registration", method = { RequestMethod.GET, RequestMethod.POST })
	public String signUpAction(@ModelAttribute("userRegistrationMap") User user, BindingResult result,
			Model map, HttpServletRequest req) {
		/*System.out.println("Inside Action Controller");
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());*/
		String method = req.getMethod();
		if (("GET").equals(method)) {
			System.out.println("Inside Get Registration Controller");
			map.addAttribute("userRegistrationMap", new User());
			return "signUp";
		} else {
			System.out.println("Inside Post Registration Controller");
			regValidator.validate(user, result);
			if (result.hasErrors()) {
				return "signUp";
			} else {
				registerService.checkRegistration(user);
			}
			return "redirect:/login.do";
		}
	}
}

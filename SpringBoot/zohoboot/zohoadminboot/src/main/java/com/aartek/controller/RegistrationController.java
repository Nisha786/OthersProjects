package com.aartek.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	private RegistrationValidator regValidator;

	@Autowired
	private RegistrationService resService;

	@RequestMapping(value = "/registration", method = { RequestMethod.GET, RequestMethod.POST })
	public String showRegistration(@ModelAttribute("registerMap") User user, Model model, BindingResult result,
			HttpServletRequest req, HttpServletResponse res) {
		String method = req.getMethod();
		if ("GET".equals(method)) {
			model.addAttribute("registerMap", user);
			return "signUp";
		} else {
			regValidator.validate(user, result);
			if (result.hasErrors()) {
				return "signUp";
			}
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			String lastName = resService.registrationService(user);
			System.out.println(lastName);
			if (lastName != null) {
				
				try {
					res.sendRedirect("login");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return "signUp";
		}

	}
}

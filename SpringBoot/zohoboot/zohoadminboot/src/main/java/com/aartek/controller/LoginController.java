package com.aartek.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.User;
import com.aartek.service.LoginService;
import com.aartek.validator.LoginValidator;

@Controller
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private LoginValidator loginValidator;

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String showLogin(@ModelAttribute("userMap") User user, Model model, BindingResult result,
			HttpServletRequest req, HttpServletResponse res) {
		logger.info("inside Controller");
		String method = req.getMethod();
		if ("GET".equals(method)) {
			model.addAttribute("userMap", user);
			return "login";
		} else {
			loginValidator.validate(user, result);
			if (result.hasErrors()) {
				return "login";
			}
			String mail = user.getEmail();
			String pass = user.getPassword();
			User user1 = loginService.getLogin(user);
			//System.out.println(user1.getEmail()+"..."+user1.getPassword());
			
			if (user1.getEmail().equals(mail) && user1.getPassword().equals(pass)) {
				 HttpSession session = req.getSession();
				 session.setAttribute("userSession", user1);
				try {
					res.sendRedirect("products");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Not Found");
				return "login";
			}
			return "login";
		}
	}
	
	@GetMapping(value="/logOutUser")
	public String logout(HttpServletRequest req){
		req.getSession().invalidate();
		return "redirect:/login";
	}
	
}

package com.aartek.controller;

import java.io.IOException;
import java.util.Map;

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
import com.aartek.service.LoginService;
import com.aartek.validator.LoginValidator;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private LoginValidator loginValidator;

	/*
	 * @RequestMapping("/login") public String showLogin(Map<String, Object>
	 * map) { System.out.println("Inside controller"); map.put("userMap", new
	 * User()); return "login"; }
	 */

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	private String signInAction(@ModelAttribute("userMap") User user, BindingResult results, Model map,
			HttpServletRequest req, HttpServletResponse res) {
		/*System.out.println("Inside Action Controller");
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());*/
		String method = req.getMethod();
		if (("GET").equals(method)) {
			System.out.println("Inside Login Get controller");
			map.addAttribute("userMap", new User());
			return "login";
		} else {
			loginValidator.validate(user, results);
			if (results.hasErrors()) {
				return "login";
			} else {
				if (loginService.checkLogin(user).equals("User Valid")) {
					try {
						System.out.println("Valid Login");
						HttpSession session = req.getSession();
						session.setAttribute("userLoginSession",user);
						res.sendRedirect("products.do");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else{
					
				}
			}
			System.out.println("Inside Login Post");
			return "login";
		}
	}
	@RequestMapping("/logout")
	public String logoutUser(HttpServletRequest req,HttpServletResponse res){
		req.getSession().removeAttribute("userLoginSession");
		return "redirect:/login.do";
	}

}

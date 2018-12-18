package com.aartek.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aartek.model.User;
import com.aartek.service.UserServiceImpl;

@Controller
public class LoginController {
	
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/")
	public String indexShow() {
		return "index";
	}

	@GetMapping("/loginView")
	public String showLogin(User user, Model model) {
		model.addAttribute("userMap", user);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("userMap")User user,Model model,HttpServletResponse res){
		List<User> list = userService.checkLogin(user);
		if(list.size()>0){
			System.out.println("Succes");
		}
		return "login";
	}

	@GetMapping("/registrationView")
	public String showSignUp(User user,Model model){
		model.addAttribute("registerMap", user);
		model.addAttribute("userRecords",userService.findAll());
		return "signUp";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("registerMap") User user,Model model,HttpServletResponse req){
		String str = userService.addUser(user);
		model.addAttribute("userRecords",userService.findAll());
		
		return "redirect:/registrationView";
	}
}

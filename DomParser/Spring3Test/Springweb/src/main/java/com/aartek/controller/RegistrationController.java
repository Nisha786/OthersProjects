package com.aartek.controller;

import javax.imageio.spi.RegisterableService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.User;
import com.aartek.service.RegistrationService;

@Controller
public class RegistrationController {
	private static Logger logger = Logger.getLogger(RegistrationController.class);
	@Autowired
	private RegistrationService regService;
	@RequestMapping("/registrationView")
	public String getRegistrationView(Model model,User user){
		model.addAttribute("userRegisterModel", user);
		return "signup";
	}
	
	@RequestMapping(value="/registartion",method=RequestMethod.POST)
	public String registration(@ModelAttribute("userRegisterModel")User user,Model model){
		logger.info(user.getFirstName());
		String res = regService.addUserService(user);
        if(res != null){
        	logger.info(res);
        }
		return null;
	}
}

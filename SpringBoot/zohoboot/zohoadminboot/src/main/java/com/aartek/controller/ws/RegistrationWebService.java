package com.aartek.controller.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.model.User;
import com.aartek.service.RegistrationService;

@Controller
public class RegistrationWebService {
   @Autowired
   private RegistrationService regService;
   
   @RequestMapping(value="/registrationView",method=RequestMethod.POST)
   @ResponseBody
   public String addUserRecords(@RequestBody User user){
	 return regService.registrationService(user);
   }
}

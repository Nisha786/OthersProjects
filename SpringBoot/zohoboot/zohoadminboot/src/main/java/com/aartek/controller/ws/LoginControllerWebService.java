package com.aartek.controller.ws;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.model.User;
import com.aartek.service.LoginService;

@Controller
public class LoginControllerWebService {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getLogin(@PathVariable String id){
		System.out.println(id);
		return "login";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	@ResponseBody
	public User getAuthantication(@RequestBody User user,HttpServletRequest req){
		User user1 = loginService.getLogin(user);
		System.out.println(user1.getEmail());
		/*//Getting Header Information
		Enumeration<String> e = req.getHeaderNames();
		while(e.hasMoreElements()){
			String name = (String)e.nextElement();
			if(name.equals("email") || name.equals("pass") ){
				System.out.println(req.getHeader(name));				
			}
		}*/
		return user1;
	}

}

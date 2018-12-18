package com.aartek.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;
import com.aartek.service.LoginService;

import mockit.Mock;
import mockit.MockUp;

public class TestLoginService {
	
	@Before
	public void setUp(){
		
		new MockUp<LoginRepository>() {
			@Mock
			String checkLogin(User user){
				return "succes";
			}
		};
		new MockUp<LoginService>() {
			@Mock
			String checkLogin(User user){
				return "SefviceSucces";
			}
		};
		
	}
	

	@Test
	public void testCheckLogin() {
		User user = new User();
		LoginService loginService = new LoginService();
		String str = loginService.checkLogin(user);
		assertEquals("String returned ", "SefviceSucces", str);
		
	}

}

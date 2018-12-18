package com.aartek.admintest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.aartek.controller.LoginController;
import com.aartek.model.User;
import com.aartek.service.LoginService;

import mockit.Mock;
import mockit.MockUp;

@RunWith(JUnit4.class)
public class TestLoginController {
	@Before
	public void setUp() {
		new MockUp<User>() {
			
		};
		
		new MockUp<LoginService>() {
			@Mock
			String checkLogin(User user) {
				return "succes";
			}
		};
	}

	@Test
	public void testChecklogin() {
		User user = new User();
		LoginService loginService = new LoginService();
		String str = loginService.checkLogin(user);
		//System.out.println(str);
		assertEquals("String Returned", "succes", str);
	}

	@Ignore
	public void testLogoutUser() {
		fail("Not yet implemented");
	}

}

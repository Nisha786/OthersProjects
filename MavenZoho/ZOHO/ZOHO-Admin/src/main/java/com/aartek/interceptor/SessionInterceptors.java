package com.aartek.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aartek.model.User;

@Component
public class SessionInterceptors implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		System.out.println("Inside Prehandle Sessioninterceptor");
		User user = (User) req.getSession().getAttribute("userLoginSession");
		// System.out.println(user.getEmail());
		if (user == null || user.equals("")) {
			res.sendRedirect("login.do");
			return false;
		}
		req.setAttribute("loginSession", user.getEmail());
		return true;
	}

	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception e)
			throws Exception {
		System.out.println("Inside AfterComplete SessionInterceptor");

	}

	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView mv)
			throws Exception {

		System.out.println("Inside PostHandler SessionIntercpeptor");
	}

}

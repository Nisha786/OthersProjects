package com.aartek.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aartek.model.User;

@Component
public class SessiontInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		System.out.println("Inside PreHandle : ");
		User user = (User)req.getSession().getAttribute("userSession");
		if (user == null || user.equals(" ") ) {
			res.sendRedirect("login");
			return false;
		}
		req.setAttribute("userLoginSession",user.getEmail());
		return true;
	}

	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception e)
			throws Exception {
		System.out.println("Inside AfterComplete");

	}

	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView mv)
			throws Exception {

		System.out.println("Inside PostHandler");
	}

}

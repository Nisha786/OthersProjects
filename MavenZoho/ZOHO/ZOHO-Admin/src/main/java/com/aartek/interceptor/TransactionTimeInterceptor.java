package com.aartek.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TransactionTimeInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		System.out.println("Inside TransactionInterceptor PreHandler");
		return true;
	}
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object obj, Exception e)
			throws Exception {
		System.out.println("Inside TransactionInterceptor AfterCompletion");
	}

	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView mv)
			throws Exception {
		System.out.println("Inside TransactionInterceptor PostHandler");
	}


}

package com.aartek.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		System.out.println("Inside prehandle");
		String email = null;
		String pass = null;
		Map<String,String> map = new HashMap<String, String>();
		Enumeration<String> e = req.getHeaderNames();
		while(e.hasMoreElements()){
			String name = (String)e.nextElement();
		    map.put(name, req.getHeader(name));
		}
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

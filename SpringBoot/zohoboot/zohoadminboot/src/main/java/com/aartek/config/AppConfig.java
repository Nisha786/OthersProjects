package com.aartek.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.aartek.interceptor.SessiontInterceptor;

@Component
public class AppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private SessiontInterceptor sessionIterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionIterceptor).addPathPatterns("/**").excludePathPatterns("/login/**");
		
	}
}

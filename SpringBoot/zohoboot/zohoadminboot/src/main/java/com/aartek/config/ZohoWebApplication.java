package com.aartek.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.aartek")
@SpringBootApplication
public class ZohoWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ZohoWebApplication.class, args);
		System.out.println("Hello World");
	}
}

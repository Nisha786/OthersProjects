package com.aartek.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.aartek")
@SpringBootApplication
public class ZohoWebJpaApplication {
   public static void main(String[] args) {
	SpringApplication.run(ZohoWebJpaApplication.class, args);
	System.out.println("Hello World");
}
}

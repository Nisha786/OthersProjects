package com.aartek.aspect;

import java.sql.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AllAspect {
	long time;
	/*@Before("execution(* com.aartek.impl.CustomerImpl.addCustomer(..))")
	public void beforeCustomer(JoinPoint joinPoint) {
		time = System.currentTimeMillis();
		System.out.println(new Date(time));
		System.out.println("Before Excution Start");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("-------");
	}

	@After("execution(* com.aartek.impl.CustomerImpl.addCustomer(..))")
	public void AfterCustomer(JoinPoint joinPoint) {
		long time2 = System.currentTimeMillis();
		System.out.println(time2-time);
		System.out.println("Before Excution Start");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("-------");
	}
	
	@Before("execution(* com.aartek.impl.CustomerImpl.addCustomerThrow(..))")
	public void beforeCustomerThrow(JoinPoint joinPoint) {
		time = System.currentTimeMillis();
		System.out.println(new Date(time));
		System.out.println("Before Excution Start");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("-------");
	}

	@After("execution(* com.aartek.impl.CustomerImpl.addCustomerThrow(..))")
	public void AfterCustomerThrow(JoinPoint joinPoint) {
		long time2 = System.currentTimeMillis();
		System.out.println("Excution Time For addCisuomer Throw Method "+(time2-time));
		System.out.println("Before Excution Start");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("-------");
	}*/
	
	@Pointcut("execution(* com.aartek.impl.CustomerImpl*.*(..))")
	public void customerMethods(){
		System.out.println("Customers Aspects Begins");
	}
	@Before("customerMethods()")
	public void before(){
		System.out.println("Before Intiliase Customers");
	}
	
	@After("customerMethods()")
	public void after(){
		System.out.println("After Cutstomer");
	}
	
	@AfterReturning("customerMethods()")
	public void afterReturning(){
		System.out.println("After Returing Customer");
	}
	
	@AfterThrowing("customerMethods()")
	public void afterThrowing(){
		System.out.println("After Throwing");
	}
	
	@Around("customerMethods()")
	public void around(){
		System.out.println("Around");
	}
}

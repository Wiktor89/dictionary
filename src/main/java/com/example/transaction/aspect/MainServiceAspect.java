package com.example.transaction.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MainServiceAspect {

	@Before("execution(* com.*.*.service.ServiceCRUD.*(..))")
	public void test() {
		log.info("Before method:");
	}

	@After(value = "execution(* com.*.*.service.ServiceCRUD.*(..))")
	public void getAfter() {
		log.info("After");
	}

	@AfterReturning(value = "execution(* com.*.*.service.ServiceCRUD.*(..))")
	public void getReturn() {
		log.info("AfterReturning");
	}

	@AfterThrowing(value = "execution(* com.*.*.service.ServiceCRUD.*(..))")
	public void getThrowable() {
		log.info("AfterThrowing");
	}
}

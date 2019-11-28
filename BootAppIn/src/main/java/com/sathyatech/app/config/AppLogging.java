package com.sathyatech.app.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Component
@Aspect
public class AppLogging {

	final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Pointcut("execution(* com..sathyatech.app..*.*(..))")
	public void point1(){}
	
	@Before("point1()")
	public void beforeMsg(){
		log.debug("Method Execution Starts");
	}
	
	@Around("point1()") //JP
	public Object getTotalTime(ProceedingJoinPoint jp){
		StopWatch watch=new StopWatch(jp.getTarget().getClass().getName());
		
		Object ob=null;
		try {
			watch.start(jp.getSignature().getName());
			ob = jp.proceed();
			watch.stop();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.info(watch.prettyPrint());
		return ob;
	}

	@AfterThrowing(pointcut="point1()",throwing="th")
	public void getErrors(Throwable th){
	  log.error(th.getMessage());
	}
	
	@After("point1()")
	public void afterMsg(){
		log.debug("Method Execution End");
	}	
}

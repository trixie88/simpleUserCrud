package com.trix.simpleCrud.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Pointcut("execution (* com.trix.simpleCrud.controller.*.*(..))")
	private void pointCutForControllerPackage() {
	}

	@Pointcut("execution (* com.trix.simpleCrud.service.*.*(..))")
	private void pointCutForServicePackage() {
	}

	@Pointcut("execution (* com.trix.simpleCrud.dao.*.*(..))")
	private void pointCutForDaoPackage() {
	}

	@Pointcut("pointCutForControllerPackage() || pointCutForServicePackage() || pointCutForSDaoPackage()")
	private void pointCutforWholeApplication() {
	}

	@Before("pointCutforWholeApplication()")
	public void beforeAnyMethod(JoinPoint theJoinPoint) {
		MethodSignature method = (MethodSignature) theJoinPoint.getSignature();
		String nameOfMethod = method.toString();
		myLogger.info("====> Advice @Before applied on method: " + nameOfMethod);

		Object[] methodArguments = theJoinPoint.getArgs();
		for (Object argument : methodArguments) {
			myLogger.info("====> Arguments of Method: " + argument);
		}
	}

	@AfterReturning(pointcut = "pointCutforWholeApplication()", returning = "result")
	public void afterReturning(JoinPoint theJoinPoint, Object result) {
		MethodSignature method = (MethodSignature) theJoinPoint.getSignature();
		String nameOfMethod = method.toString();
		myLogger.info("====> Advice @AfterReturning applied on method: " + nameOfMethod);
		myLogger.info("====> result of method: " + result);

	}

}

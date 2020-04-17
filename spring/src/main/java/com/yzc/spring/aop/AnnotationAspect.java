package com.yzc.spring.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author :  20160301301
 * @date : 2018/9/6 10:02
 */
@Component
@Aspect
public class AnnotationAspect {
    private final static Logger logger = LogManager.getLogger();

    @Pointcut("execution(public * com.yzc.spring.controller.*.*(..))")
    public void controllerCut() {

    }

    @Before("controllerCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Aspect before...");
    }

    @After("controllerCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("Aspect after...");
    }

    @AfterReturning(pointcut = "controllerCut()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
        System.out.println("Aspect afterReturning executed, return result is " + returnVal);
    }

    @Around("controllerCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Aspect around start..");
        try {
            Object result = pjp.proceed();
            System.out.println("Aspect around end");
            return result;
        } catch (Throwable ex) {
            System.out.println("Aspect error in around");
            throw ex;
        }
    }

    @AfterThrowing(pointcut = "controllerCut()", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error) {
        System.out.println("Aspect error:" + error);
    }
}

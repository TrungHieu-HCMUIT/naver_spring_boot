package com.example.naver.spring.boot.aspect.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class EmployeeLogAspect {

    private Logger logger = LoggerFactory.getLogger(EmployeeLogAspect.class);

    @Before("execution(* com.example.naver.spring.boot.api.employee.service.EmployeeService.*(..))")
    public void beforeExecution(JoinPoint joinPoint) {
        logger.info("before calling " + joinPoint.toString());
    }

    @After("execution(* com.example.naver.spring.boot.api.employee.service.EmployeeService.*(..))")
    public void afterExecution(JoinPoint joinPoint) {
        logger.info("after calling " + joinPoint.toString());
    }

}

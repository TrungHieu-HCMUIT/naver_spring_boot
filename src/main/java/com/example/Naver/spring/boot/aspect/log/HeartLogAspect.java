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
public class HeartLogAspect {

    private final Logger logger = LoggerFactory.getLogger(HeartLogAspect.class);

    @Before("execution(* com.example.naver.spring.boot.api.heart.service.HeartService.*(..))")
    public void beforeExecution(JoinPoint joinPoint) {
        logger.info("before calling " + joinPoint.getSignature().getName());
        logger.info(",--.                                 ,--.   ");
        logger.info("|  ,---.   ,---.   ,--,--. ,--.--. ,-'  '-. ");
        logger.info("|  .-.  | | .-. : ' ,-.  | |  .--' '-.  .-' ");
    }

    @After("execution(* com.example.naver.spring.boot.api.heart.service.HeartService.*(..))")
    public void afterExecution(JoinPoint joinPoint) {
        logger.info("|  | |  | \\   --. \\ '-'  | |  |      |  |   ");
        logger.info("`--' `--'  `----'  `--`--' `--'      `--'   ");
        logger.info("after calling " + joinPoint.getSignature().getName());
    }

}

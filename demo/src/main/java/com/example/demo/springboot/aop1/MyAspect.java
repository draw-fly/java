package com.example.demo.springboot.aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class MyAspect {

    @Pointcut("execution(* com.example.demo.springboot.aop1.UserServiceImpl.printUser(..))")
    public void pointCut(){

    }
    @DeclareParents(value = "com.example.demo.springboot.aop1.UserServiceImpl", defaultImpl =UserValidateImpl.class)
    public UserValidator userValidator;

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before");
        jp.proceed();
        System.out.println("around after");
    }
    @Before("pointCut()")
    public void before(){
        System.out.println("before");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning");

    }
    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }}

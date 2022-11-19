package com.example.demo.springboot.aop;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Interceptor{

    @Override
    public boolean before(){
        System.out.println("before");
        return true;
    }

    @Override
    public boolean userAround(){
        System.out.println("使用");
        return false;
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before.......");
        return invocation.proceed();
    }

    @Override
    public void after(){
        System.out.println("after");
    }

    @Override
    public void afterReturning(){
        System.out.println("afterReturning........");
    }

    @Override
    public void afterThrowing(){
        System.out.println("afterThrowing..........");
    }
}

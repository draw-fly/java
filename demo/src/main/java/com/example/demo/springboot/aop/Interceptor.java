package com.example.demo.springboot.aop;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {
    //事前方法
    boolean before();

    //事后方法
    void after();

    //替代原有事件方法
    Object around(Invocation invocation ) throws InvocationTargetException, IllegalAccessException;

    //事后返回方法
    void afterReturning();

    //事后异常方法
    void afterThrowing();

    //是否使用around替换原有方法

    boolean userAround();
}

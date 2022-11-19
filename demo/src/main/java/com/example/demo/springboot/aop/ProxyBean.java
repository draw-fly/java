package com.example.demo.springboot.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {
    private Object target;

    private Interceptor interceptor;

    public static Object getProxyBean(Object target, Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(args, method, target);
        this.interceptor.before();
        Object obj = null;
        try{
            if (this.interceptor.userAround()){
                obj = this.interceptor.around(invocation);
            }else{
                obj = method.invoke(target, args);
            }
        }catch (Exception e){
            exceptionFlag = true;
        }
        this.interceptor.after();
        if (exceptionFlag){
            this.interceptor.afterThrowing();
        }else {
            this.interceptor.afterReturning();
            return obj;
        }
        return null;
    }


}

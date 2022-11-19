package com.example.demo.springboot.aop;

import java.lang.reflect.Proxy;

public class TestAop {
    public static void main(String[] args) {
        HelloServiceImpl helloService = new HelloServiceImpl();
        HelloService helloService2 = new HelloServiceImpl();
        HelloService proxyBean = (HelloService)ProxyBean.getProxyBean(helloService, new MyInterceptor());
        HelloService proxyBean1 = (HelloService) ProxyBean.getProxyBean(helloService2, new MyInterceptor());
        System.out.println(proxyBean.getClass());

        System.out.println(proxyBean1.getClass().getSimpleName());
        proxyBean.sysHello("哈哈哈哈！");
    }
}

package com.example.demo.springboot.aop;

public class HelloServiceImpl implements HelloService{
    public void sysHello(String name){
        System.out.println("hello world!" + name);
    }
}

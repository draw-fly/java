package com.example.demo.springboot.di;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal{


    @Override
    public void user(){
        System.out.println("狗【"+Dog.class.getSimpleName()+"是看门用的");
    }
}

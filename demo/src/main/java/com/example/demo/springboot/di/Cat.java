package com.example.demo.springboot.di;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal{

    @Override
    public void user(){
        System.out.println("猫"+Cat.class.getSimpleName()+"是抓老鼠的");
    }
}

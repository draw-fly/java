package com.example.demo.springboot.aop1;

import com.example.demo.springboot.User;

public class UserValidateImpl implements UserValidator{
    @Override
    public boolean validate(User user){
        System.out.println("引入类来增强！");
        return user != null;
    }

}

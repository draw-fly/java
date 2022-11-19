package com.example.demo.springboot.aop1;

import com.example.demo.springboot.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public void printUser(User user){
        System.out.println("aop");
    }
}

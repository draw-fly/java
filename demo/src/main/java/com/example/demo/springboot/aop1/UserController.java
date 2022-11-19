package com.example.demo.springboot.aop1;

import com.example.demo.springboot.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    @ResponseBody
    public User printUser(){
        User user = new User();
        user.setId("123");
        user.setUserName("user");
        user.setNote("aop测试");
        UserValidator userValidator = (UserValidator)userService;
        if (userValidator.validate(user)){
            userService.printUser(user);
        }

        return user;
    }

}

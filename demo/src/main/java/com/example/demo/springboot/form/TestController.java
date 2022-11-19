package com.example.demo.springboot.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    @NoRepeatSubmit
    @Transactional
    public Object getValue(){
        return  "完成验证！";
    }
}

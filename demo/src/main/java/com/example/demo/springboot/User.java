package com.example.demo.springboot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Data
//@SuppressWarnings("all")
//@ConfigurationProperties(prefix = "taco.order")
@Component
//@PropertySource("classpath: application.yml")
public class User {

    private String id;
    @Value("${taco.order.userName}")
    private String userName;
    @Value("${taco.order.note}")
    private String note;

    @Value("${taco.order.id}")
    public void sour(String id){
        System.out.println(id);
    }

}

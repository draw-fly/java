package com.example.demo.springboot;

import com.example.demo.DemoApplication;
import com.example.demo.springboot.config.AppConfig;
import com.example.demo.springboot.config.ScopeBean;
import com.example.demo.springboot.di.BusinessPerson;
import com.example.demo.springboot.di.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class IocTest {

    public static void main(String[] args) {
//        SpringApplication.run(IocTest.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ScopeBean bean = context.getBean(ScopeBean.class);
        ScopeBean bean1 = context.getBean(ScopeBean.class);
        System.out.println(bean == bean1);
        context.close();

//        Person bean = context.getBean(BusinessPerson.class);
//        bean.service();
//        log.info(String.valueOf(bean.getId()));

    }


}

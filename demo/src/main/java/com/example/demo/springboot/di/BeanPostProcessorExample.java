package com.example.demo.springboot.di;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName){
        System.out.println("BeanPostProcessor 调用 postProcessBeforeInitialization方法 参数是【"+bean.getClass().getSimpleName()+"】 【"+beanName+"】");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
        System.out.println("BeanPostProcessor 调用 postProcessAfterInitialization方法 参数是【"+bean.getClass().getSimpleName()+"】 【"+beanName+"】");
        return bean;
    }
}

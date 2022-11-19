package com.example.demo.springboot.di;

import com.example.demo.springboot.User;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BusinessPerson implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

//    @Autowired(required = false)
//    @Qualifier("cat")
//    @Resource(name = "dog")
    private Animal dog1;//@Autowired提供规则： 首先根据类型找对应的Bean，如果对应Bean的类型不唯一，那他会根据其属性名称和bean的名称进行匹配

//
//    @Autowired
    public BusinessPerson(@Qualifier("dog") Animal dog){
        this.dog1 = dog;

    }
    /*@Autowired和@Qualifier可以放在属性和方法上   @Qualifier只能放到构造方法的参数上
    * */
    @Override
    public void service(){
        this.dog1.user();
    }

    @Override
    @Autowired
    @Qualifier("dog")
    public void setAnimal( Animal animal){
        System.out.println("延迟依赖注入");
        this.dog1 = animal;
    }
    //消除歧义性： @Primary 修改优先权 @Qualifier 和@Autowire组合使用按照指定的bean名称注入

    @Override
    public void setBeanName(String beanName){
        System.out.println("【"+this.getClass().getSimpleName()+"】调用BeanNameAware的setBeanName方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory){
        System.out.println("【"+this.getClass().getSimpleName()+"】调用BeanFactoryAware的setBeanFactory方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        System.out.println("【"+this.getClass().getSimpleName()+"】调用ApplicationContextAware的setApplicationText方法");
    }
    @Override
    public void afterPropertiesSet(){
        System.out.println("【"+this.getClass().getSimpleName()+"【调用InitializingBean的afterPropertiesSet方法");
    }
    @PostConstruct
    public void init(){
        System.out.println("【"+this.getClass().getSimpleName()+"】注解@PostConstruct定义的自定义初始化方法");
    }
    @PreDestroy
    public void destroy1(){
        System.out.println("【"+this.getClass().getSimpleName()+"】注解@PreDestroy定义的自定义初始化方法");
    }
    @Override
    public void destroy(){
        System.out.println("【"+this.getClass().getSimpleName()+"】调用DisposableBean的destroy方法");
    }

}

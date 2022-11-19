package com.example.demo.springboot.config;

import com.example.demo.springboot.User;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.example.demo.*"})//, excludeFilters = {@ComponentScan.Filter(classes = {User.class})} , lazyInit = true)
public class AppConfig {
//    @Bean
//    public User initUser(){
//        User user = new User();
//        user.setId(1L);
//        user.setUserName("hf");
//        user.setNote("重要");
//        return user;
//    }
    @SuppressWarnings("all")
    @Bean(name = "datasource", destroyMethod = "close")
    @Conditional(DataBaseCondition.class)//判断数据源是否有效再决定是否装配bean   配合Condition接口使用  实现matches方法
    public DataSource getDataSource(@Value("${database.driverName}") String driver, @Value("${database.url}")String url, @Value("${database.username}") String username, @Value("${database.password}") String password){


        Properties props = new Properties();
        props.setProperty("driver", driver);
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);
        DataSource dataSource = null;
        String name = AppConfig.class.getSimpleName();
        System.out.println(name);
        try{
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}

package com.example.demo.springboot.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DataBaseCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata){
        Environment env = context.getEnvironment();

        return env.containsProperty("database.driverName")&& env.containsProperty("database.url")&&env.containsProperty("database.username")&& env.containsProperty("database.password");
    }
}

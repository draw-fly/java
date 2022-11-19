package com.example.demo.springboot.redis;

import com.example.demo.springboot.redis.config.initRedisTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;

public class Chapter7Main {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        ApplicationContext ctx =  new AnnotationConfigApplicationContext(initRedisTemplate.class);
        RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
//        单一操作
        redisTemplate.opsForValue().set("key1", "value1");

        redisTemplate.opsForHash().put("hash", "field", "hvalue");
//        redisTemplate.opsForList()   列表
//        redisTemplate.opsForSet()    集合
//        redisTemplate.opsForZSet()    有序集合

//        某个键的数据连续操作
        redisTemplate.boundHashOps("hash");
        redisTemplate.boundValueOps("string");



    }
//    同一连接执行多个redis命令
    public void useRedisCallback(RedisTemplate redisTemplate){
        redisTemplate.execute((RedisConnection rc) -> {
            rc.set("key1".getBytes(), "value".getBytes());
            rc.hSet("hash".getBytes(), "field".getBytes(), "hvalue".getBytes());
            return null;
        });
    }

    public void userSessionCallback(RedisTemplate redisTemplate){
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations ro) throws DataAccessException {
                ro.opsForValue().set("key1", "value1");
                ro.opsForHash().put("hash", "field", "hvalue");
                return null;
            }
        });
    }
}

package com.example.demo.springboot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/home")
    @ResponseBody
    public Map<String ,Object> testStringAndHash() {
        redisTemplate.opsForValue().set("key1", "value1");
//        采用的是jdk序列化器 无法运算
        redisTemplate.opsForValue().set("int_key", "1");

        stringRedisTemplate.opsForValue().set("int", "1");
//        运算  自增1
        stringRedisTemplate.opsForValue().increment("int", 1);
//        获取底层jedis连接
        Jedis jedis = (Jedis) Objects.requireNonNull(stringRedisTemplate.getConnectionFactory()).getConnection().getNativeConnection();
//        减1操作，redisTemplate不支持
        jedis.decr("int");
        HashMap<String, String> map = new HashMap<>();
        map.put("field1", "value1");
        map.put("field2", "value2");
        stringRedisTemplate.opsForHash().putAll("hash", map);
        stringRedisTemplate.opsForHash().put("hash", "field3", "value3");
        BoundHashOperations<String, Object, Object> hash = stringRedisTemplate.boundHashOps("hash");
        hash.delete("filed1", "field2");
        hash.put("field4", "value4");
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("success", true);
        return hashMap;
    }

    @RequestMapping("/multi")
    @ResponseBody
    public Map<String, Object> testMulti(){
        redisTemplate.opsForValue().set("key1", "value1");
        List list = (List)redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
//                设置要监控的key
                redisOperations.watch("key1");
//                开启事务，在exec命令执行前，全部都只是进入队列
                redisOperations.multi();
                redisTemplate.opsForValue().set("key2", "value2");
                redisTemplate.opsForValue().increment("key1", 1);
//                值为空，命令在队列中，还未执行
                Object value2 = redisTemplate.opsForValue().get("key2");

                return redisOperations.exec();
            }
        });
        System.out.println(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }
}

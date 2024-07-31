package com.spring.crud_students.controller;

import com.spring.crud_students.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/")
public class RedisController {
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    private final String KEY_PREFIX = "com.fai.demo_redis";

    @GetMapping
    public void getKey(@RequestParam String key) {
        String fullKey = KEY_PREFIX + key;
    }

    @PostMapping
    public void addKey(@RequestParam StringEntity entity) {
        String fullKey = KEY_PREFIX + entity.getKey();
        redisTemplate.expire(fullKey, 3, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set(fullKey, entity.getValue());
    }
}

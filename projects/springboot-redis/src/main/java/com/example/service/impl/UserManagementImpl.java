package com.example.service.impl;

import com.example.service.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserManagementImpl implements UserManagement {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, Object value) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
    }

    @Override
    public void set(String key, Object value, Long time, TimeUnit t) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value, time, t);
    }

    @Override
    public Object get(String key) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

}

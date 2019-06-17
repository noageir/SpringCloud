package com.micro.system.employee.service.impl;


import com.micro.system.employee.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Noageir
 * Date:2018-05-11 23:14
 * Project:com.spring.cloud
 * Package:com.micro.system.employee.service.impl
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public void removeKey(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void removeKeys(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    @Override
    public void setValueForString(String commCodeKey, String s, long timeAlive, TimeUnit var5) {
        redisTemplate.opsForValue().set(commCodeKey, s);
        redisTemplate.expire(commCodeKey, timeAlive, var5);
    }

    @Override
    public String getValueForString(String commCodeKey) {
        return String.valueOf(redisTemplate.opsForValue().get(commCodeKey));
    }

    @Override
    public void setValueForMap(String commCodeKey, Map map, long timeAlive, TimeUnit var5) {
        redisTemplate.opsForHash().putAll(commCodeKey, map);
        redisTemplate.expire(commCodeKey, timeAlive, var5);
    }

    @Override
    public Map getValueForMap(String commCodeKey) {
        return redisTemplate.opsForHash().entries(commCodeKey);
    }

}

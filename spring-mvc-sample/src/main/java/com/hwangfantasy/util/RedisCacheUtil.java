package com.hwangfantasy.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author hwangfantasy
 * @创建时间: 2017/3/6 17:43 <br/>
 * @方法描述: RedisCacheUtil. <br/>
 */
@Component
public class RedisCacheUtil {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     *-----------------------------------</br>
     * @作者: hwangfantasy
     * @创建日期: 2017/3/6 17:46</br>
     *-----------------------------------</br>
     * @方法描述: 批量删除对应的value
     *-----------------------------------</br>
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     *-----------------------------------</br>
     * @作者: hwangfantasy
     * @创建日期: 2017/3/6 17:46</br>
     *-----------------------------------</br>
     * @方法描述: 批量删除key
     *-----------------------------------</br>
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     *-----------------------------------</br>
     * @作者: hwangfantasy
     * @创建日期: 2017/3/6 17:46</br>
     *-----------------------------------</br>
     * @方法描述: 删除对应的value
     *-----------------------------------</br>
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     *-----------------------------------</br>
     * @作者: hwangfantasy
     * @创建日期: 2017/3/6 17:46</br>
     *-----------------------------------</br>
     * @方法描述: 判断缓存中是否有对应的value
     *-----------------------------------</br>
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     *-----------------------------------</br>
     * @作者: hwangfantasy
     * @创建日期: 2017/3/6 17:46</br>
     *-----------------------------------</br>
     * @方法描述: 读取缓存
     *-----------------------------------</br>
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     *-----------------------------------</br>
     * @作者: hwangfantasy
     * @创建日期: 2017/3/6 17:46</br>
     *-----------------------------------</br>
     * @方法描述: 写入缓存
     *-----------------------------------</br>
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *-----------------------------------</br>
     * @作者: hwangfantasy
     * @创建日期: 2017/3/6 17:47</br>
     *-----------------------------------</br>
     * @方法描述: 写入缓存
     *-----------------------------------</br>
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

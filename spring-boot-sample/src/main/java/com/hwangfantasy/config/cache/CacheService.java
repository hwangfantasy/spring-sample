package com.hwangfantasy.config.cache;

import net.spy.memcached.MemcachedClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/27 <br/>
 * @方法描述: CacheService. <br/>
 */
@Service
public class CacheService {
    @Autowired
    private MemcachedClient memcachedClient;
    private static final Logger logger = LoggerFactory.getLogger(CacheService.class);


    /**
     * 缓存1分钟
     **/
    public final static int Minute = 60;
    /**
     * 缓存1小时
     **/
    public final static int Hour = 60 * 60;
    /**
     * 缓存1天
     **/
    public final static int Day = 60 * 60 * 24;
    /**
     * 长期缓存
     **/
    public final static int Ever = 0;


    /**
     * 将对象放入缓存
     ***/
    public void cacheSet(String table, String key, Object value, int time) {
        if (table != null && key != null)
            if (table.trim().length() > 0)
                memcachedClient.set(table + "_" + key, time, value);
    }

    /**
     * 读取缓存数据
     ***/
    public Object cacheGet(String table, String key) {
        try {
            if (table != null && key != null)
                if (table.trim().length() > 0)
                    return memcachedClient.get(table + "_" + key);
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 按KEY获取缓存
     *
     * @param key
     * @return
     */
    public Object cacheGet(String key) {
        try {
            if (key != null && key.trim().length() > 0) {
                return memcachedClient.get(key);
            }
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 读取缓存数据
     ***/
    public Object cacheGetAndTouch(String table, String key, int exp) {
        if (table != null && key != null)
            if (table.trim().length() > 0)
                return memcachedClient.getAndTouch(table + "_" + key, exp);
        return null;
    }

    public long cacheIncr(String table, String key, int by) {
        if (table != null && key != null)
            if (table.trim().length() > 0)
                return memcachedClient.incr(table + "_" + key, by);
        return -1;
    }

    public void cacheDelete(String table, String key) {
        if (table != null && key != null)
            if (table.trim().length() > 0)
                memcachedClient.delete(table + "_" + key);
    }

    public Long cacheIncr(String key, int by, long defaultValue) {
        if (StringUtils.isNotBlank(key)) {
            try {
                long result = memcachedClient.incr(key, by, defaultValue);
                return result;
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return 0l;
            }
        }
        return 0l;
    }
}

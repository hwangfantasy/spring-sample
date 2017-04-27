package com.hwangfantasy.config.cache;

import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.FailureMode;
import net.spy.memcached.spring.MemcachedClientFactoryBean;
import net.spy.memcached.transcoders.SerializingTranscoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @作者 hwangfantasy
 * @创建时间: 2017/4/27 <br/>
 * @方法描述: CacheConfig. <br/>
 */
@Configuration
public class CacheConfig {
    private static final ResourceBundle RB = ResourceBundle.getBundle("cache", Locale.getDefault(),CacheConfig.class.getClassLoader());

    @Bean
    public MemcachedClientFactoryBean memcachedClientFactoryBean() {
        MemcachedClientFactoryBean memcachedClient = new MemcachedClientFactoryBean();
        memcachedClient.setServers(RB.getString("main.memcached.host").trim()+":"+RB.getString("main.memcached.port"));
        memcachedClient.setProtocol(ConnectionFactoryBuilder.Protocol.BINARY);
        memcachedClient.setTranscoder(transcoder());
        memcachedClient.setOpTimeout(1000);
        memcachedClient.setTimeoutExceptionThreshold(1998);
        memcachedClient.setLocatorType(ConnectionFactoryBuilder.Locator.CONSISTENT);
        memcachedClient.setFailureMode(FailureMode.Redistribute);
        memcachedClient.setUseNagleAlgorithm(false);
        return memcachedClient;
    }

    @Bean
    public SerializingTranscoder transcoder() {
        SerializingTranscoder transcoder = new SerializingTranscoder();
        transcoder.setCompressionThreshold(1024);
        return transcoder;
    }
}

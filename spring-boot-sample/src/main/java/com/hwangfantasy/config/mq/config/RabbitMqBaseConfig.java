package com.hwangfantasy.config.mq.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @作者 hwangfantasy
 * @创建时间: 2017/4/27 <br/>
 * @方法描述: RabiitMqBaseConfig. <br/>
 */
@Configuration
public class RabbitMqBaseConfig {
    private static final ResourceBundle RB = ResourceBundle.getBundle("mq", Locale.getDefault(), RabbitMqBaseConfig.class.getClassLoader());

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(RB.getString("rabbitmq.address"));
        connectionFactory.setUsername(RB.getString("rabbitmq.username"));
        connectionFactory.setPassword(RB.getString("rabbitmq.password"));
        connectionFactory.setVirtualHost(RB.getString("rabbitmq.virtualHost"));
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }
}

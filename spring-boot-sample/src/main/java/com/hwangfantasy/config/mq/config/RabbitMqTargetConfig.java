package com.hwangfantasy.config.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/27 <br/>
 * @方法描述: RabbitMqTargetConfig. <br/>
 */
@Configuration
public class RabbitMqTargetConfig {
    private static final ResourceBundle RB = ResourceBundle.getBundle("mq", Locale.getDefault(), RabbitMqTargetConfig.class.getClassLoader());


    @Autowired
    RabbitMqBaseConfig rabbitMqBaseConfig;
    @Bean
    public Queue targetResultQueue() {
        Queue queue = new Queue(RB.getString("rabbitmq.target.queue.name"), true, false, false);
        queue.setAdminsThatShouldDeclare(rabbitMqBaseConfig.amqpAdmin());
        return queue;
    }

    @Bean
    public Exchange targetResultExchange() {
        DirectExchange exchange = new DirectExchange(RB.getString("rabbitmq.target.exchange.name"), true, false);
        exchange.setAdminsThatShouldDeclare(rabbitMqBaseConfig.amqpAdmin());
        return exchange;
    }

    @Bean
    public Binding targetResultBinding() {
        Binding binding = new Binding(targetResultQueue().getName(), Binding.DestinationType.QUEUE,
                targetResultExchange().getName(), RB.getString("rabbitmq.target.routingKey"), null);
        binding.setAdminsThatShouldDeclare(rabbitMqBaseConfig.amqpAdmin());
        return binding;
    }
}

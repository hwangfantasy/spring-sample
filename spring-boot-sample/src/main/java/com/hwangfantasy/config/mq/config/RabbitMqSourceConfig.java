package com.hwangfantasy.config.mq.config;

import com.hwangfantasy.config.mq.listener.RabbitMqListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/27 <br/>
 * @方法描述: RabbitMqSourceConfig. <br/>
 */
@Configuration
public class RabbitMqSourceConfig {
    private static ResourceBundle RB = ResourceBundle.getBundle("mq", Locale.getDefault(), RabbitMqSourceConfig.class.getClassLoader());

    @Autowired
    private RabbitMqListener rabbitMqListener;
    @Autowired
    @Qualifier("connectionFactory")
    ConnectionFactory connectionFactory;

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory);
    }
    @Bean
    public Queue sourceQueue() {
        Queue queue = new Queue(RB.getString("rabbitmq.source.queue.name"), true, false, false);
        queue.setAdminsThatShouldDeclare(amqpAdmin());
        return queue;
    }

    @Bean
    public Exchange sourceExchange() {
        DirectExchange exchange = new DirectExchange(RB.getString("rabbitmq.source.exchange.name"), true, false);
        exchange.setAdminsThatShouldDeclare(amqpAdmin());
        return exchange;
    }

    @Bean
    public Binding sourceBinding() {
        Binding binding = new Binding(sourceQueue().getName(), Binding.DestinationType.QUEUE, sourceExchange().getName(), RB.getString("rabbitmq.source.routingKey"), null);
        binding.setAdminsThatShouldDeclare(amqpAdmin());
        return binding;
    }

    @Bean
    public SimpleMessageListenerContainer paymentListenerContainer() {
        SimpleMessageListenerContainer paymentListenerContainer = new SimpleMessageListenerContainer();
        paymentListenerContainer.setConnectionFactory(connectionFactory);
        paymentListenerContainer.setQueues(this.sourceQueue());
        paymentListenerContainer.setMessageListener(rabbitMqListener);
        paymentListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return paymentListenerContainer;
    }
}

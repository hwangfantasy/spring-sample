package com.hwangfantasy.config.mq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/27 <br/>
 * @方法描述: RabbitMqPublisher. <br/>
 */
@Component
public class RabbitMqPublisher {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final ResourceBundle RB = ResourceBundle.getBundle("mq", Locale.getDefault(),RabbitMqPublisher.class.getClassLoader());

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqPublisher.class);

    private void sendTargetMessage(String type,String message){
        logger.info("给Target发送支付结果消息");
        try {
            MessageProperties mp = new MessageProperties();// define a general mp
            mp.setType(type);
            Message msg = new Message(message.getBytes(), mp);// builder for message
            amqpTemplate.send(RB.getString("rabbitmq.target.exchange.name"),RB.getString("rabbitmq.target.routingKey"), msg);
            logger.info("发送消息:" + message + ",type=" + type);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}

package com.hwangfantasy.config.mq.listener;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/27 <br/>
 * @方法描述: RabbitMqMessageListener. <br/>
 */
@Component
public class RabbitMqListener implements ChannelAwareMessageListener {
    private final static Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        boolean result = true; // 默认返回结果为 true
        try {
            String type = message.getMessageProperties().getType();
            String msgBody = new String(message.getBody());
            logger.info("收到Source回调消息，类型：" + type + "，内容：" + msgBody);
            switch (type) {
                case "paySuccess": {// 支付成功
                    // 业务逻辑
                    break;
                }
                default:
                    break;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (result) { // 确保消息能消费
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } else {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }
}

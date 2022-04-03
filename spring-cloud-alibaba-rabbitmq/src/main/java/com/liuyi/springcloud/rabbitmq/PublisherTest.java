package com.liuyi.springcloud.rabbitmq;

import com.liuyi.springcloud.rabbitmq.config.RabbitMQConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName Publisher
 * @description：
 * @author：liuyi
 * @Date：2022/3/18 23:00
 */
@SpringBootTest
public class PublisherTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void publisher(){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "big.black.dog", "message");
        System.out.println("消息发送成功");
    }

    @Test
    public void publishWithProps() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "big.black.dog", "messageWithProps",
                (message) -> {
                    message.getMessageProperties().setCorrelationId("123");
                    return message;
                });
        System.out.println("消息发送成功");
    }

    /**
     * @Author liuyi
     * @Description //保证数据到达交换机
     * @Date 2022/3/29 23:50
     * @Param []
     * @return void
     **/
    @Test
    public void publisherWithConfirms(){
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if(ack){
                    System.out.println("消费已经到达交换机");
                }else {
                    System.out.println("消费没有送到交换机,需要做一些补偿措施");
                }
            }
        });
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "big.black.dog", "message");
        System.out.println("消息发送成功");
    }

    /**
     * @Author liuyi
     * @Description //保证数据到达队列
     * @Date 2022/3/29 23:50
     * @Param []
     * @return void
     **/
    @Test
    public void publisherWithReturn(){
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returned) {
                String msg = new String(returned.getMessage().getBody());
                System.out.println("消息: "+msg +"路由队列失败!!做补偿操作");
            }
        });
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "big.black.dog", "message");
        System.out.println("消息发送成功");
    }

    /**
     * @Author liuyi
     * @Description //数据持久化
     * @Date 2022/3/29 23:50
     * @Param []
     * @return void
     **/
    @Test
    public void publisherWithBasicProperties(){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "big.black.dog", "message",
                (message) -> {
                    message.getMessageProperties().setDeliveryMode(MessageProperties.DEFAULT_DELIVERY_MODE);
                    return message;
                });
        System.out.println("消息发送成功");
    }

}

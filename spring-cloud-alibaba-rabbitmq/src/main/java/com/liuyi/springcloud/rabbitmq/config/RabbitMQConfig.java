package com.liuyi.springcloud.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitMQConfig
 * @description：
 * @author：liuyi
 * @Date：2022/3/29 21:46
 */
@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "boot-exchange";
    public static final String QUEUE = "boot-queue";
    public static final String ROUTING_KEY = "*.black.*";


    /**
     * @Author liuyi
     * @Description // 创建交换机
     * @Date 2022/3/29 21:56
     * @Param []
     * @return org.springframework.amqp.core.Exchange
     **/
    @Bean
    public Exchange exchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE).build();
    }

    @Bean
    public Queue queue(){
        return QueueBuilder.durable(QUEUE).build();
    }

    @Bean
    public Binding binding(Exchange exchange,Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY).noargs();
    }

}

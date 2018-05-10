package com.autolink.springboot.mq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by shileichao on 2018/5/10.
 */
@Component
public class HelloSender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send(String message){
        String sendMsg = message + new Date();
        System.out.println("Sender1:"+sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue",sendMsg);
    }
}

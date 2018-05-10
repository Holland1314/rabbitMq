package com.autolink.springboot.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by shileichao on 2018/5/10.
 */
@Component
@RabbitListener(queues="helloQueue")
public class HelloReciever2 {

    @RabbitHandler
    public void process(String message){
        System.out.println("Reciever2:"+message);

    }
}

package com.autolink.springboot.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by shileichao on 2018/5/10.
 */
@Component
@RabbitListener(queues="helloQueue")
public class HelloReceiver1 {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver1:"+hello);

    }


}

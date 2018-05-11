package com.autolink.springboot.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by shileichao on 2018/5/11.
 */
@Component
@RabbitListener(queues = "fanout.B")
@Slf4j
public class FanoutRecieverB {

    @RabbitHandler
    public void process(String message){
        log.info("FanoutRecieverB:"+message);
    }
}

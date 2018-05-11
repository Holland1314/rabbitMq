package com.autolink.springboot.mq.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shileichao on 2018/5/11.
 */
@Component
@Slf4j
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String msg = "fanoutSender: hello i am fanoutSender";
        log.info("fanoutSender:"+msg);

        this.amqpTemplate.convertAndSend("fanoutExchange","abcd.ee",msg);

    }

}

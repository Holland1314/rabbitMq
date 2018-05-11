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
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String msg1 = "I am topic.message msg=========";
        log.info("topicSender1:"+msg1);

        this.amqpTemplate.convertAndSend("exchange","topic.message",msg1);

        String msg2 = "I am topic.messages msg=======";

        log.info("topicSender2:"+msg2);

        this.amqpTemplate.convertAndSend("exchange","topic.messages",msg2);

    }



}

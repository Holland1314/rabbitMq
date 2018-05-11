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
public class QVehicleSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message){
        amqpTemplate.convertAndSend("exchange","q_vehicle",message);
        log.info("QVehicle Sender:"+message
        );
    }
}

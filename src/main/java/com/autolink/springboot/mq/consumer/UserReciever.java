package com.autolink.springboot.mq.consumer;

import com.autolink.springboot.mq.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by shileichao on 2018/5/10.
 */
@Component
@RabbitListener(queues = "user")
@Slf4j
public class UserReciever {

    @RabbitHandler
    public void process(User user) {
        System.out.println("user reciever:"+user.getName()+"/"+user.getPass());
    }

}

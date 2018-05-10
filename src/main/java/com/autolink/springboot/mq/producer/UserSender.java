package com.autolink.springboot.mq.producer;

import com.autolink.springboot.mq.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shileichao on 2018/5/10.
 */

@Component
@Slf4j
public class UserSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        User user = new User();
        user.setName("chao");
        user.setPass("123456");
        System.out.println("user send:"+user.getName()+"/"+user.getPass());
        rabbitTemplate.convertAndSend("user",user);
        log.info("userSender:"+user.toString());
        rabbitTemplate.convertAndSend("","","");


    }
}

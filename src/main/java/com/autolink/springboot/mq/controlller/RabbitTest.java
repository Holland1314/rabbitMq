package com.autolink.springboot.mq.controlller;

import com.autolink.springboot.mq.consumer.HelloReceiver1;
import com.autolink.springboot.mq.consumer.UserReciever;
import com.autolink.springboot.mq.producer.HelloSender1;
import com.autolink.springboot.mq.producer.HelloSender2;
import com.autolink.springboot.mq.producer.UserSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shileichao on 2018/5/10.
 */
@Slf4j
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
    @Autowired
    private HelloSender1 helloSender1;

    @Autowired
    private HelloSender2 helloSender2;

    @Autowired
    private UserSender userSender;

    /**
     * 单生产 但消费
     * @return
     */
    @PostMapping("/hello")
    public String hello(){
        helloSender1.send("hello1");
        return "";
    }

    @PostMapping("/oneToMany")
    public void oneToMany(){
        for(int i=0;i<10;i++){
            helloSender1.send("helloRabbit"+i);
        }
    }

    @PostMapping("manyToMany")
    public void manyToMany(){
        for(int i=0;i<10;i++){
            helloSender1.send("helloRabbit1:"+i);
            helloSender2.send("helloRabbit2:"+i);
        }
    }

    @PostMapping("userTest")
    public void userTest(){
        userSender.send();
        log.info("user test");
    }

}

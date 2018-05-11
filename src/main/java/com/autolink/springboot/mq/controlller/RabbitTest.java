package com.autolink.springboot.mq.controlller;

import com.autolink.springboot.mq.consumer.HelloReceiver1;
import com.autolink.springboot.mq.consumer.UserReciever;
import com.autolink.springboot.mq.producer.*;
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

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private CallBackSender callBackSender;

    @Autowired
    private QVehicleSender qVehicleSender;

    /**
     * 单生产 但消费
     *
     * @return
     */
    @PostMapping("/hello")
    public String hello() {
        helloSender1.send("hello1");
        return "";
    }

    /**
     * 单生产 多消费
     */
    @PostMapping("/oneToMany")
    public void oneToMany() {
        for (int i = 0; i < 10; i++) {
            helloSender1.send("helloRabbit" + i);
        }
    }

    /**
     * 多生产 多消费
     */
    @PostMapping("manyToMany")
    public void manyToMany() {
        for (int i = 0; i < 10; i++) {
            helloSender1.send("helloRabbit1:" + i);
            helloSender2.send("helloRabbit2:" + i);
        }
    }

    /**
     * 实体类传输
     */
    @PostMapping("userTest")
    public void userTest() {
        userSender.send();
        log.info("user test");
    }

    /**
     * topic
     */
    @PostMapping("topicSender")
    public void topicSender() {
        topicSender.send();
        log.info("topic sender");
    }

    /**
     * fanoutTest
     */
    @PostMapping("fanoutTest")
    public void fanoutSender() {
        fanoutSender.send();
        log.info("fanout sender");
    }

    @PostMapping("callback")
    public void callback() {
        callBackSender.send();
    }



    @PostMapping("qVehicle")
    public void qVehicle(){
        String msg = "hello q vehicle";
        this.qVehicleSender.send(msg);
        log.info("qVehicle Sender:"+msg);

    }

}

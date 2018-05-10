package com.autolink.springboot.mq.rabbitMq;

import com.autolink.springboot.mq.producer.HelloSender1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqApplicationTests {

//    @Autowired
//    private HelloSender1 helloSender1;

    @Test
    public void contextLoads() {
        //helloSender1.send();
        System.out.println("send message");
    }

}

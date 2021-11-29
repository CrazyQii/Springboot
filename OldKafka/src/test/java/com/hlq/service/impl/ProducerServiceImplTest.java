package com.hlq.service.impl;


import com.alibaba.fastjson.JSON;
import com.hlq.config.KafkaConfig;
import com.hlq.entity.User;
import com.hlq.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerServiceImplTest {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private KafkaConfig kafkaConfig;

    @Test
    public void sendMessageForever() {
        User user = new User();
        while (true) {
            user.setUsername("hlq");
            user.setPassword("123456");
            try {
                producerService.sendMessage(kafkaConfig.getTopic(), null, JSON.toJSONString(user));
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
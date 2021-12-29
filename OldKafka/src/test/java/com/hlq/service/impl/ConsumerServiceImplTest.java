package com.hlq.service.impl;

import com.hlq.config.KafkaConfig;
import com.hlq.kafka.ConsumerService;
import com.hlq.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConsumerServiceImplTest {

    @Autowired
    private KafkaConfig kafkaConfig;

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private UserService userService;

    @Test
    public void dealUserMessage() {
        consumerService.receiveMessage(kafkaConfig.getTopic(), kafkaConfig.getConsumer().getTopicCount(), userService.getClass());
    }
}
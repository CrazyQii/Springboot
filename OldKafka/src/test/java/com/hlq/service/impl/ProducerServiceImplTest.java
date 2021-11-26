package com.hlq.service.impl;


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

    @Test
    public void sendMessage() {
        producerService.sendMessage(null, null, null);
    }
}
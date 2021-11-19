package com.hlq.kafka;

import com.hlq.kafka.entity.User;
import com.hlq.kafka.service.ConsumerService;
import com.hlq.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HanLq
 */
@SpringBootApplication
public class KafkaMain implements ApplicationRunner {

    @Autowired
    private ProducerService producerServiceImpl;

    @Autowired
    private ConsumerService consumerServiceImpl;

    /**
     * 启动方法
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        String topic = "TEST";
//        User user = new User("hanlinqi", "123456");
//        producerServiceImpl.sendMessage(topic, null, user);
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaMain.class, args);
    }


}

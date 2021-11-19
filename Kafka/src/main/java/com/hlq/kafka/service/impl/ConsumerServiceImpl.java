package com.hlq.kafka.service.impl;


import com.hlq.kafka.config.KafkaConstants;
import com.hlq.kafka.service.ConsumerService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author HanLq
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    private final KafkaConsumer<String, Object> consumer;

    /**
     * 创建消费者
     */
    public ConsumerServiceImpl() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BROKER_LIST);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID_CONFIG);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        this.consumer = new KafkaConsumer<String, Object>(props);
    }

    public void consumeMessage(String topic) {
        try {
            consumer.subscribe(Collections.singleton(topic));
            ConsumerRecords<String, Object> records = consumer.poll(Duration.ofSeconds(10));
            for (ConsumerRecord<String, Object> record : records) {
                System.out.println("Consumer message " + record.value());
            }
        } catch (Exception e) {
            LOGGER.error("Kafka消费者消费失败，异常错误 | ERROR [{}]", e.toString());
        }
    }
}

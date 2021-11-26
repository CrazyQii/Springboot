package com.hlq.service.impl;

import com.hlq.config.KafkaConfig;
import com.hlq.service.ProducerService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @program: ProducerServiceImpl
 * @description: 生产者实现
 * @author: hanLinQi
 * @create: 2021-11-26 15:11
 **/
@Service
public class ProducerServiceImpl implements ProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerServiceImpl.class);

    @Autowired
    private KafkaConfig kafkaConfig;

    private KafkaProducer<String, String> producer = null;

    /**
     * 初始化生产者
     * @return 成功 true，失败 false
     */
    private boolean init() {
        LOGGER.info("start to init kafka producer...");
        if (this.producer != null) {
            return true;
        } else {
            try {
                Properties prop = new Properties();
                prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getProducer().getBrokerList());
                prop.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaConfig.getProducer().getClientId());
                prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
                prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
                this.producer = new KafkaProducer<String, String>(prop);
                LOGGER.info("kafka init successfully !!!");
                return true;
            } catch (Exception e) {
                LOGGER.error("producer config properties error | " + e);
                return false;
            }
        }
    }

    @Override
    public void sendMessage(String topic, String key, String message) {
        long start = System.currentTimeMillis();
        if (this.init()) {
            try {
                Future<RecordMetadata> metadataFuture = this.producer.send(new ProducerRecord<>(topic, key, message));
            } catch (Exception e) {
                LOGGER.error("producer send message error | " + e);
            }
        } else {
            LOGGER.error("Kafka producer init error !!!");
        }
    }
}

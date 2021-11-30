package com.hlq.service.impl;

import com.alibaba.fastjson.JSON;
import com.hlq.config.KafkaConfig;
import com.hlq.service.ProducerService;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

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

    private Producer<String, String> producer = null;

    /**
     * 初始化生产者
     * @return 成功 true，失败 false
     */
    private boolean init() {
        if (this.producer != null) {
            return true;
        } else {
            LOGGER.info("初始化生产者...");
            try {
                Properties prop = new Properties();
                prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getProducer().getBootstrapServers());
                prop.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaConfig.getProducer().getClientId());
                prop.put(ProducerConfig.ACKS_CONFIG, kafkaConfig.getProducer().getAcks());
                prop.put(ProducerConfig.RETRIES_CONFIG, kafkaConfig.getProducer().getRetries());
                prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
                prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
                this.producer = new KafkaProducer<String, String>(prop);
                LOGGER.info("生产者初始化成功 !!!");
                return true;
            } catch (Exception e) {
                LOGGER.error("生产者配置属性失败，ERROR | " + e);
                if (this.producer != null) {
                    this.producer.close();
                }
                return false;
            }
        }
    }

    @Override
    public void  sendMessage(String topic, String key, String message) {
        long start = System.currentTimeMillis();
        if (this.init()) {
            this.producer.send(new ProducerRecord<>(topic, key, message), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e != null) {
                        LOGGER.error("发送消息失败, 花费时间 {}ms ERROR | {}", (System.currentTimeMillis() - start) ,e);
                    } else {
                        LOGGER.info("消息发送成功, 花费时间 {}ms: topic[{}] partition[{}] offset[{}] message[{}]",
                                (System.currentTimeMillis() - start), recordMetadata.topic(),
                                recordMetadata.partition(), recordMetadata.offset(), message);
                    }
                }
            });
        } else {
            LOGGER.error("生产者未初始化 !!!");
        }
    }

    @Override
    public void sendMessage(String topic, String key, Object object) {
        String message = JSON.toJSONString(object);
        this.sendMessage(topic, key, message);
    }
}

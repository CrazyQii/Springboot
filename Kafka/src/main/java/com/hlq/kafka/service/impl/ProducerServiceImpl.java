package com.hlq.kafka.service.impl;

import com.hlq.kafka.config.KafkaConstants;
import com.hlq.kafka.service.ProducerService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * @author HanLq
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerServiceImpl.class);

    private KafkaProducer<String, Object> producer;

    /**
     * 创建生产者
     */
    public ProducerServiceImpl() {
        try {
            Properties props = new Properties();
            props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BROKER_LIST);
            props.put(ProducerConfig.CLIENT_ID_CONFIG, KafkaConstants.CLIENT_ID);
            props.put(ProducerConfig.ACKS_CONFIG, KafkaConstants.ACK);
            props.put(ProducerConfig.RETRIES_CONFIG, KafkaConstants.RET_RISE);
            props.put(ProducerConfig.BATCH_SIZE_CONFIG, KafkaConstants.BATCH_SIZE);
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            this.producer = new KafkaProducer<String, Object>(props);
        } catch (Exception e) {
            LOGGER.error("Kafka 生产者初始化失败，异常错误 | ERROR: " + e);
        }
    }


    @Override
    public void sendMessage(String topic, String key, Object o) {
        try {
            ProducerRecord<String, Object> record = new ProducerRecord<>(topic, key, o);
            RecordMetadata metadata = this.producer.send(record).get();
            LOGGER.info("发送数据到Kafka，topic: [{}] | offset [{}] | partition [{}] | msg [{}]",
                    metadata.topic(), metadata.offset(), metadata.partition(), record.value());
        } catch (Exception e) {
            LOGGER.error("Kafka 生产者生产失败，异常错误 | ERROR: " + e);
        }
    }
}

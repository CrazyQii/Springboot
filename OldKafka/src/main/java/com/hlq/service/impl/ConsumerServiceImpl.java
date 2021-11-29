package com.hlq.service.impl;

import com.hlq.config.KafkaConfig;
import com.hlq.service.ConsumerService;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @program: ConsumerServiceImpl
 * @description: 消费者实现类
 * @author: hanLinQi
 * @create: 2021-11-29 18:23
 **/
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    @Autowired
    private KafkaConfig kafkaConfig;

    private ConsumerConnector consumer = null;

    /**
     * 初始化消费者
     * @return 成功 true， 失败 false
     */
    private boolean init() {
        if (this.consumer != null) {
            return true;
        } else {
            LOGGER.info("开始初始化消费者");
            try {
                Properties props = new Properties();
                props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getConsumer().getBrokerList());
                props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConfig.getConsumer().getGroupId());
                props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaConfig.getConsumer().getAutoOffsetReset());
                props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
                props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
                this.consumer = Consumer.createJavaConsumerConnector(new kafka.consumer.ConsumerConfig(props));
                LOGGER.error("消费者初始化成功!!!");
                return true;
            } catch (Exception e) {
                LOGGER.error("消费者初始化失败，ERROR | " + e);
                if (this.consumer != null) {
                    this.consumer.shutdown();
                }
                return false;
            }
        }
    }

    @Override
    public void dealMessage(String topic) {
        Map<String, Integer> map = new HashMap<>(1);
        if (this.init()) {
            map.put(topic, 1);
            Map<String, List<KafkaStream<byte[], byte[]>>> consumerMessageStreams = this.consumer.createMessageStreams(map);
            KafkaStream<byte[], byte[]> stream = consumerMessageStreams.get(topic).get(0);

            ConsumerIterator<byte[], byte[]> iterator = stream.iterator();

            while (iterator.hasNext()) {
                String j = new String(iterator.next().message());
                System.out.println(j);
            }
        } else {
            LOGGER.error("消费者未启动！！！");
        }
    }
}

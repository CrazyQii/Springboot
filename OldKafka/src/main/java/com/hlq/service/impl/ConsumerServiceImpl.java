package com.hlq.service.impl;

import com.hlq.config.KafkaConfig;
import com.hlq.service.ConsumerService;
import com.hlq.service.KafkaProcessor;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
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
                props.put("zookeeper.connect", kafkaConfig.getConsumer().getZookeeperConnect());
                props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConfig.getConsumer().getGroupId());
                props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaConfig.getConsumer().getAutoOffsetReset());
                props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, kafkaConfig.getConsumer().getEnableAutoCommit());
                this.consumer = Consumer.createJavaConsumerConnector(new kafka.consumer.ConsumerConfig(props));
                LOGGER.info("消费者初始化成功!!!");
                return true;
            } catch (Exception e) {
                LOGGER.error("消费者初始化失败，ERROR | " + e);
                return false;
            }
        }
    }

    @Override
    public void receiveMessage(String topic, Integer topicCount, Class clazz) {
        Map<String, Integer> topicCountMap = new HashMap<>(1);
        if (this.init()) {
            try {
                // Consumer将用多少个线程消费该topic
                // Consumer实例个数 * 每个Consumer的topicCount个数  <= partition
                topicCountMap.put(topic, topicCount);
                StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
                StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());

                Map<String, List<KafkaStream<String, String>>> consumerMessageStreams =
                        this.consumer.createMessageStreams(topicCountMap, keyDecoder, valueDecoder);
                KafkaStream<String, String> stream = consumerMessageStreams.get(topic).get(0);

                if (stream.isEmpty()) {
                    throw new RuntimeException("kafka steam 不可用 " + stream.toString());
                }

                ConsumerIterator<String, String> iterator = stream.iterator();
                MessageAndMetadata<String, String> metadata = null;

                // 实现类（多态）
                KafkaProcessor processor = (KafkaProcessor) clazz.newInstance();

                long noCommitMsgCount = 0;
                while (iterator.hasNext()) {
                    try {
                        metadata = iterator.next();
                        LOGGER.info("接收消息成功，topic [{}] partition [{}] offset [{}]",
                                metadata.topic(), metadata.partition(), metadata.offset());
                        processor.processor(metadata.message());
                    } catch (Exception e) {
                        LOGGER.info("消费异常 ERROR | topic [{}] partition [{}] offset [{}] ",
                                metadata.topic(), metadata.partition(), metadata.offset());
                    }
                    noCommitMsgCount += 1;
                    if (noCommitMsgCount >= 10) {
                        // 处理10条消息，再提交位移，避免消息丢失
                        LOGGER.info("提交位移 topic [{}] partition [{}] offset [{}]",
                                metadata.topic(), metadata.partition(), metadata.offset());
                        this.consumer.commitOffsets();
                        noCommitMsgCount = 0;
                    }
                }
            } catch (RuntimeException e) {
                LOGGER.error("接收Kafka消息失败， ERROR | " + e);
            } catch (Exception e) {
                LOGGER.error("接收Kafka消息失败， ERROR | " + e);
            }
        } else {
            LOGGER.error("消费者未启动！！！");
        }
        if (this.consumer != null) {
            this.consumer.shutdown();
        }
    }
}

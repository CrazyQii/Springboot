package com.hlq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

/**
 * @program: KafkaConfig
 * @description: kafka配置信息
 * @author: hanLinQi
 * @create: 2021-11-26 15:17
 **/

@Component
@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaConfig {
    private String topic;
    private Producer producer;
    private Consumer consumer;

    /**
     * 生产者
     */
    @Data
    public static class Producer {
        private String bootstrapServers;
        private String clientId;
        private String acks;
        private String retries;
    }

    /**
     * 消费者
     */
    @Data
    public static class Consumer {
        private String zookeeperConnect;
        private String groupId;
        private String autoOffsetReset;
        private Integer topicCount;
        private Boolean enableAutoCommit;
    }
}

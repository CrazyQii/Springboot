package com.hlq.kafka.service;

/**
 * @author HanLq
 */
public interface ProducerService {

    /**
     * 发送消息
     * @param topic 主题
     * @param key 键（用于判断发送的分区）
     * @param o 发送的值
     */
    void sendMessage(String topic, String key, Object o);
}

package com.hlq.service;

/**
 * @program: ProducerService
 * @author: hanLinQi
 * @create: 2021-11-26 15:09
 **/
public interface ProducerService {

    /**
     * 发送消息
     * @param topic 主题
     * @param key key，用于指定需要发送的分区
     * @param message 消息
     */
    void sendMessage(String topic, String key, String message);
}

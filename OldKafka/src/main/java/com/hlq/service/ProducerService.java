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
     * @param key kafka用于区分发送的分区
     * @param message 消息
     */
    void sendMessage(String topic, String key, String message);

    /**
     * 发送消息
     * @param topic 主题
     * @param key kafka用于区分发送的分区
     * @param object 消息对象
     */
    void sendMessage(String topic, String key, Object object);
}

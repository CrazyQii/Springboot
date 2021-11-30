package com.hlq.service;

/**
 * @program: ConsumerService
 * @author: hanLinQi
 * @create: 2021-11-26 15:09
 **/
public interface ConsumerService {
    /**
     * 处理信息
     * @param topic 主题
     * @param topicCount 消费者同一topic启动线程数量
     * @param clazz 调用消费者的类
     */
    <T> void receiveMessage(String topic, Integer topicCount, Class<T> clazz);
}

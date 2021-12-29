package com.hlq.kafka;

/**
 * @program: KafkaProcess
 * @author: hanLinQi
 * @create: 2021-11-30 10:17
 **/
public interface KafkaProcessor {

    /**
     * kafka消息处理器
     * @param message 接收到的消息
     */
    void processor(String message);
}

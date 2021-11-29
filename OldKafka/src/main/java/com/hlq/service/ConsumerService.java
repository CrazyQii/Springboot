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
     */
    void dealMessage(String topic);
}

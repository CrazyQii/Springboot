package com.hlq.factory.partern.IIR;

import com.hlq.factory.partern.Redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @program: IIR
 * @description: 模拟集群2
 * @author: hanLinQi
 * @create: 2022-02-25 17:05
 **/

public class IIR {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        LOGGER.info("IIR获取数据 value {}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        LOGGER.info("IIR写入数据 key: {} value: {}", key, value);
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        LOGGER.info("IIR写入数据 key: {} value: {} timeout: {} timeUnit: {}", key, value, timeout, timeUnit);
        dataMap.put(key, value);
    }

    public void del(String key) {
        LOGGER.info("IIR删除数据 key:{}", key);
        dataMap.remove(key);
    }
}

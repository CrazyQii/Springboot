package com.hlq.factory.partern.EGM;

import com.hlq.factory.partern.Redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @program: EGM
 * @description: 模拟集群1
 * @author: hanLinQi
 * @create: 2022-02-25 17:05
 **/

public class EGM {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String gain(String key) {
        LOGGER.info("EGM获取数据 value {}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        LOGGER.info("EGM写入数据 key: {} value: {}", key, value);
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        LOGGER.info("EGM写入数据 key: {} value: {} timeout: {} timeUnit: {}", key, value, timeout, timeUnit);
        dataMap.put(key, value);
    }

    public void delete(String key) {
        LOGGER.info("EGM删除数据 key:{}", key);
        dataMap.remove(key);
    }
}

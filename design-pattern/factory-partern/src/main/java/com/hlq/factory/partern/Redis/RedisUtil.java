package com.hlq.factory.partern.Redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @program: RedisUtil
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-25 16:57
 **/

public class RedisUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        LOGGER.info("Redis获取数据 value {}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        LOGGER.info("Redis写入数据 key: {} value: {}", key, value);
        dataMap.put(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        LOGGER.info("Redis写入数据 key: {} value: {} timeout: {} timeUnit: {}", key, value, timeout, timeUnit);
        dataMap.put(key, value);
    }

    public void delete(String key) {
        LOGGER.info("Redis 删除数据 key:{}", key);
        dataMap.remove(key);
    }
}

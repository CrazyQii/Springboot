package com.hlq.factory.partern;

import java.util.concurrent.TimeUnit;

/**
 * @program: CacheService
 * @author: hanLinQi
 * @create: 2022-02-25 17:28
 **/
public interface CacheService {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void delete(String key);
}

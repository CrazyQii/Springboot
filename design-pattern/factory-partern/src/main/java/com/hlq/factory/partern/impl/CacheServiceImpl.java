package com.hlq.factory.partern.impl;

import com.hlq.factory.partern.CacheService;
import com.hlq.factory.partern.factory.adapter.ICacheAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @program: CacheServiceImpl
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-25 17:30
 **/

public class CacheServiceImpl implements CacheService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheServiceImpl.class);

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public void set(String key, String value) {

    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {

    }

    @Override
    public void delete(String key) {

    }
}

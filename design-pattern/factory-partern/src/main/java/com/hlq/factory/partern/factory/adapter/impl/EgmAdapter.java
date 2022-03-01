package com.hlq.factory.partern.factory.adapter.impl;

import com.hlq.factory.partern.EGM.EGM;
import com.hlq.factory.partern.factory.adapter.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @program: EgmAdapter
 * @description: egm集群适配器
 * @author: hanLinQi
 * @create: 2022-02-25 17:32
 **/

public class EgmAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout,  timeUnit);
    }

    @Override
    public void delete(String key) {
        egm.delete(key);
    }
}

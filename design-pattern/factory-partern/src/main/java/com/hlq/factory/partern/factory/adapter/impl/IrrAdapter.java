package com.hlq.factory.partern.factory.adapter.impl;

import com.hlq.factory.partern.IIR.IIR;
import com.hlq.factory.partern.factory.adapter.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @program: IrrAdapter
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-25 17:37
 **/

public class IrrAdapter implements ICacheAdapter {

    private IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void delete(String key) {
        iir.del(key);
    }
}

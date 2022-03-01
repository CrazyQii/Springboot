package com.hlq.factory.partern.factory.adapter;

import java.util.concurrent.TimeUnit;

/**
 * @program: ICacheAdaper
 * @author: hanLinQi
 * @create: 2022-02-25 17:32
 **/
public interface ICacheAdapter {

    String get(String key);


    public void set(String key, String value);

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit);

    public void delete(String key);
}

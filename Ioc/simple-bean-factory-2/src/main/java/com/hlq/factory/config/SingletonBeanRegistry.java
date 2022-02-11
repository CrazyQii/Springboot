package com.hlq.factory.config;

/**
 * @program: SingletonBeanRegistry
 * @author: hanLinQi
 * @create: 2022-02-11 14:43
 **/
public interface SingletonBeanRegistry {

    /**
     * 获取单例对象
     * @param name
     * @return
     */
    Object getSingleton(String name);
}

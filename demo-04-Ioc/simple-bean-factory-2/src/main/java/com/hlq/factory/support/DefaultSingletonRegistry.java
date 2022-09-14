package com.hlq.factory.support;

import com.hlq.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: DefaultSingletonRegistry
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-11 14:46
 **/

public class DefaultSingletonRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 获取单例对象
     * @param name
     * @return
     */
    @Override
    public Object getSingleton(String name) {
        return singletonObjects.get(name);
    }

    /**
     * 注册单例对象，使用protect可以让继承该接口的类使用
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}

package com.hlq;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: BeanFactory
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-11 13:41
 **/

public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 获取bean对象
     * @param name
     * @return
     */
    public Object getBean(String name) {
        return beanDefinitionMap.get(name);
    }

    /**
     * 注册中心，将bean添加到HashMap当中
     * @param name
     * @param beanDefinition
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}

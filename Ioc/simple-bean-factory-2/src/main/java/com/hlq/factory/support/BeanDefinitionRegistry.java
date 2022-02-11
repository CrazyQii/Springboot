package com.hlq.factory.support;

import com.hlq.BeansException;
import com.hlq.factory.config.BeanDefinition;

import java.beans.Beans;

/**
 * @program: BeanDefinitionRegistry
 * @author: hanLinQi
 * @create: 2022-02-11 15:16
 **/
public interface BeanDefinitionRegistry {

    /**
     * Bean对象注册中心
     * @param beanName
     * @param beanDefinition
     * @throws BeansException
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}

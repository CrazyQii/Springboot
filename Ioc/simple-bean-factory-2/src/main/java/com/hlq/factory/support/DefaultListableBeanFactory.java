package com.hlq.factory.support;

import com.hlq.BeansException;
import com.hlq.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: DefaultListableBeanFactory
 * @description: 核心类实现
 * @author: hanLinQi
 * @create: 2022-02-11 15:15
 **/

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String name) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new BeansException("No bean named " + name + " is defined");
        }
        return beanDefinition;
    }
}

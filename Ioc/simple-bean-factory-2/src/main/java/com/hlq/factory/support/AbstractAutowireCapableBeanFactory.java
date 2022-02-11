package com.hlq.factory.support;

import com.hlq.BeansException;
import com.hlq.factory.config.BeanDefinition;

/**
 * @program: AbstractAutowireCapableBeanFactory
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-11 15:08
 **/

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 实现了 Bean 的实例化操作 newInstance
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }
}

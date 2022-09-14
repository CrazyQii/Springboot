package com.hlq.factory.support;

import com.hlq.BeansException;
import com.hlq.factory.BeanFactory;
import com.hlq.factory.config.BeanDefinition;
import com.hlq.factory.config.SingletonBeanRegistry;

/**
 * @program: AbstractBeanFactory
 * @description:
 * AbstractBeanFactory 首先继承了 DefaultSingletonBeanRegistry，也就具备了使用单例注册类方法。
 * @author: hanLinQi
 * @create: 2022-02-11 14:50
 **/

public abstract class AbstractBeanFactory extends DefaultSingletonRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    /**
     * 获取Bean对象
     * @param name
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    /**
     * 创建Bean对象
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}

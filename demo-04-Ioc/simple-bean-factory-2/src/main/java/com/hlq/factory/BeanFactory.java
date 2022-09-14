package com.hlq.factory;

import com.hlq.BeansException;

/**
 * @program: BeanFactory
 * @author: hanLinQi
 * @create: 2022-02-11 15:00
 **/
public interface BeanFactory {

    /**
     * 获取单例bean对象
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object getBean(String beanName) throws BeansException;
}

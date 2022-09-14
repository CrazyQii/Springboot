package com.hlq;

/**
 * @program: BeanDefinition
 * @description: Bean容器，用于spring bean对象的初始化
 * @author: hanLinQi
 * @create: 2022-02-11 13:40
 **/

public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}

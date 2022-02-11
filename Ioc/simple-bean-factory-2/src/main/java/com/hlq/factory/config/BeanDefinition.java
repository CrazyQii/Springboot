package com.hlq.factory.config;

/**
 * @program: BeanDefinition
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-11 14:40
 **/

public class BeanDefinition {

    /**
     * 将 Bean 的实例化操作放到容器中进行处理
     */
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}

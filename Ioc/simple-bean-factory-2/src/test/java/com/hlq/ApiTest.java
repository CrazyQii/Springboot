package com.hlq;

import com.hlq.factory.config.BeanDefinition;
import com.hlq.factory.support.DefaultListableBeanFactory;
import com.hlq.service.UserService;
import org.junit.Test;

/**
 * @program: ApiTest
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-11 15:23
 **/

public class ApiTest {

    @Test
    public void testBeanFactory() throws BeansException {
        // 1. 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3. 第一次读取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4. 第二次读取bean
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}

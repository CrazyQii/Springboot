package com.hlq.service.impl;

import com.alibaba.fastjson.JSON;
import com.hlq.entity.User;
import com.hlq.service.KafkaProcessor;
import com.hlq.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @program: UserServiceImpl
 * @description: 用户实现类
 * @author: hanLinQi
 * @create: 2021-11-30 10:30
 **/
@Service
public class UserServiceImpl implements UserService, KafkaProcessor {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void processor(String message) {
        User user = JSON.parseObject(message, User.class);
        LOGGER.info("处理用户信息成功：用户名称[{}], 密码[{}]", user.getUsername(), user.getPassword());
    }
}

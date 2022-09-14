package com.hlq.mybatis.controller;

import com.hlq.mybatis.dto.req.SignInReq;
import com.hlq.mybatis.entity.User;
import com.hlq.mybatis.enums.BaseResult;
import com.hlq.mybatis.enums.ResponseEnum;
import com.hlq.mybatis.service.UserService;
import com.hlq.mybatis.utils.BeanConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: UserController
 * @description:
 * @author: hanLinQi
 * @create: 2022-08-21 15:30
 **/
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @GetMapping(value = "/test")
    public BaseResult<String> test() {
        return new BaseResult<>("测试返回结果");
    }

    @PostMapping(value = "/sign-in", produces = "application/json")
    public BaseResult<Boolean> register(@RequestBody SignInReq signInReq) {
        BaseResult<Boolean> result;
        LOGGER.info("用户注册请求信息: {}", signInReq.toString());
        if (StringUtils.isNotEmpty(signInReq.getPassword()) && StringUtils.isNotEmpty(signInReq.getUsername())) {
            try {
                User user = BeanConvertUtils.copy(signInReq, User.class);
                if (StringUtils.isEmpty(user.getCode())) {
                    user.setCode("999999");
                }
                int existUser = userService.register(user);
                if (existUser == 1) {
                    result = new BaseResult<>();
                    LOGGER.info("用户注册成功, 注册信息：{}", user.toString());
                } else {
                    result = new BaseResult<>(ResponseEnum.USER_ALREADY_EXIST.getCode(), ResponseEnum.USER_ALREADY_EXIST.getMessage());
                }
            } catch (MyBatisSystemException e) {
                LOGGER.error("用户注册失败，数据库操作失败 ERROR | {}", e.getMessage());
                result = new BaseResult<>(ResponseEnum.DATASOURCE_OPERATE_EXCEPTION.getCode(), ResponseEnum.DATASOURCE_OPERATE_EXCEPTION.getMessage());
            } catch (Exception e) {
                LOGGER.error("用户注册失败，发生未知错误 ERROR | {}", e.getMessage());
                result = new BaseResult<>(ResponseEnum.UNKNOWN_EXCEPTION.getCode(), ResponseEnum.UNKNOWN_EXCEPTION.getMessage());
            }
        } else {
            LOGGER.error("用户注册参数校验失败，注册信息: {}", signInReq.toString());
            result = new BaseResult<>(ResponseEnum.ILLEGAL_PARAMETER.getCode(), ResponseEnum.ILLEGAL_PARAMETER.getMessage());
        }
        return result;
    }
}

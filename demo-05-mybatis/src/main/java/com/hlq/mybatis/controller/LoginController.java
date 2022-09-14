package com.hlq.mybatis.controller;

import com.hlq.mybatis.dto.req.LoginReq;
import com.hlq.mybatis.dto.req.SignInReq;
import com.hlq.mybatis.entity.User;
import com.hlq.mybatis.enums.BaseResult;
import com.hlq.mybatis.enums.ResponseEnum;
import com.hlq.mybatis.service.UserService;
import com.hlq.mybatis.utils.BeanConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: LoginController
 * @description:
 * @author: hanLinQi
 * @create: 2022-08-31 11:07
 **/

@RestController
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserService userService;

    @PostMapping("/user/login")
    public BaseResult<String> login(@RequestBody LoginReq loginReq) {
        BaseResult<String> result;
        // 登录
        if (StringUtils.isNotEmpty(loginReq.getUsername()) && StringUtils.isNotEmpty(loginReq.getPassword())) {
            User user = BeanConvertUtils.copy(loginReq, User.class);
            result = userService.login(user);
        } else {
            LOGGER.error("登录失败，参数校验失败 user: {}", loginReq.toString());
            result = new BaseResult<>(ResponseEnum.ILLEGAL_PARAMETER.getCode(), ResponseEnum.ILLEGAL_PARAMETER.getMessage());
        }
        return result;
    }
}

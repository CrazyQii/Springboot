package com.hlq.mybatis.service.impl;

import com.hlq.mybatis.dto.res.LoginUser;
import com.hlq.mybatis.entity.User;
import com.hlq.mybatis.enums.BaseResult;
import com.hlq.mybatis.enums.ResponseEnum;
import com.hlq.mybatis.mapper.UserMapper;
import com.hlq.mybatis.service.UserService;
import com.hlq.mybatis.utils.TokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: UserServiceImpl
 * @description:
 * @author: hanLinQi
 * @create: 2022-08-21 15:22
 **/
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public BaseResult<String> login(User user) {
        BaseResult<String> result;
        try {
            // AuthenticationManager认证
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            // 如果认证不通过，给出相应提示
            // 如果认证通过，生成token，返还给前端
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            Long id = loginUser.getUser().getId();
            String token = TokenUtils.createToken(id);
            // 将用户信息存入redis，userid作为key
            result = new BaseResult<>(token);
        } catch (AuthenticationException e) {
            LOGGER.error("登录失败，认证失败，ERROR | {} ", e.getMessage());
            result = new BaseResult<>(ResponseEnum.USER_OR_PASSWORD_ERROR.getCode(), ResponseEnum.USER_OR_PASSWORD_ERROR.getMessage());
        }
        return result;
    }

    @Override
    public User findUserByUserNameAndPwd(String username, String password) {
        return null;
    }

    @Override
    public User findUser(User user) {
        return userMapper.findUser(user);
    }

    @Override
    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

    @Override
    public int register(User user) {
        User existUser = userMapper.findUserByUserNameAndPwd(user.getUsername(), user.getPassword());
        if (existUser == null) {
            return userMapper.insert(user);
        }
        return 0;
    }

}

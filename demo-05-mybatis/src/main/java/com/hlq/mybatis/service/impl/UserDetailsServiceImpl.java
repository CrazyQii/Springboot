package com.hlq.mybatis.service.impl;

import com.hlq.mybatis.dto.res.LoginUser;
import com.hlq.mybatis.entity.User;
import com.hlq.mybatis.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @program: UserDetailsServiceImpl
 * @description:
 * @author: hanLinQi
 * @create: 2022-08-29 15:50
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 根据用户名查询用户信息
        User user = userMapper.findUserByUserName(s);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return new LoginUser(user);
    }
}

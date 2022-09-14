package com.hlq.mybatis.service;

import com.hlq.mybatis.entity.User;
import com.hlq.mybatis.enums.BaseResult;

import java.util.List;

public interface UserService {

    BaseResult<String> login(User user);

    User findUserByUserName(String username);

    User findUserByUserNameAndPwd(String username, String password);

    User findUser(User user);

    int register(User user);

}

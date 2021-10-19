package com.hlq.mybatis.service.impl;

import com.hlq.mybatis.entity.User;
import com.hlq.mybatis.mapper.UserMapper;
import com.hlq.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> findAll(int page, int size) {
        return userMapper.findAll(page, size);
    }

    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(Long id) {
        userMapper.delete(id);
    }
}

package com.hlq.mybatis.service;

import com.hlq.mybatis.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll(int page, int size);  // 方法名称和xml文件中的id对应

    User findUserById(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}

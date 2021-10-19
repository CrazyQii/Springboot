package com.hlq.mybatis.mapper;

import com.hlq.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> findAll(int page, int size);  // 方法名称和xml文件中的id对应

    User findUserById(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}

package com.hlq.mybatis.mapper;

import com.hlq.mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HanLq
 */
@Mapper
@Repository
public interface UserMapper {

    User findUserById(Long id);

    User findUserByUserNameAndPwd(String username, String password);

    User findUser(User user);

    User findUserByUserName(String username);

    int insert(User user);

}

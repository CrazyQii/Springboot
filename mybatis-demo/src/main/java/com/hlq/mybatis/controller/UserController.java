package com.hlq.mybatis.controller;

import com.hlq.mybatis.entity.User;
import com.hlq.mybatis.service.UserService;
import com.hlq.mybatis.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenUtils tokenUtils;

    @PostMapping(value = "/user")
    public String findUserById(@RequestHeader("token") String token) {
        Long userId = tokenUtils.verify(token);
        if (userId != null) {
            System.out.println("userId: " + userId);
            return userService.findUserById(userId).toString();
        }
        return "token过期";
    }

    @GetMapping(value = "/user")
    public List<User> findUsers() {
        return userService.findAll(10, 1);
    }

    @PostMapping(value = "/user/{id}")
    public String login(@PathVariable("id") Long id) {
        return tokenUtils.token(id);
    }
}

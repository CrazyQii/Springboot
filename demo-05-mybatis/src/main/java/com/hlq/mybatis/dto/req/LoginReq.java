package com.hlq.mybatis.dto.req;

/**
 * @program: LoginReq
 * @description: 登录请求对象
 * @author: hanLinQi
 * @create: 2022-08-31 11:12
 **/

public class LoginReq {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginReq{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

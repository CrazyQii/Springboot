package com.hlq.mybatis.dto.req;

/**
 * @program: SignInReq
 * @description: 注册参数对象
 * @author: hanLinQi
 * @create: 2022-08-29 15:10
 **/

public class SignInReq {

    private String username;
    private String password;
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

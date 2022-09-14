package com.hlq.mybatis.enums;

/**
 * @program: ResponseEnum
 * @author: hanLinQi
 * @create: 2022-08-29 11:37
 **/
public enum ResponseEnum {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    ILLEGAL_PARAMETER(1001, "非法参数"),
    UNKNOWN_EXCEPTION(1002, "未知异常"),
    DATASOURCE_OPERATE_EXCEPTION(1003, "数据库异常"),
    NOT_FOUND_USER(2001, "用户不存在"),
    USER_OR_PASSWORD_ERROR(2002, "用户名或者密码错误"),
    USER_ALREADY_EXIST(2003, "用户已经存在");

    private Integer code;
    private String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

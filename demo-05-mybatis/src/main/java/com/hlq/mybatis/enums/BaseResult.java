package com.hlq.mybatis.enums;

/**
 * @program: BaseResult
 * @description:
 * @author: hanLinQi
 * @create: 2022-08-29 11:34
 **/

public class BaseResult<T> {

    /**
     * 状态码
     */
    private Integer code = ResponseEnum.SUCCESS.getCode();

    /**
     * 提示信息
     */
    private String message = ResponseEnum.SUCCESS.getMessage();

    /**
     * 响应数据
     */
    private T data;

    public BaseResult() {
    }

    public BaseResult(T data) {
        this.data = data;
    }

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

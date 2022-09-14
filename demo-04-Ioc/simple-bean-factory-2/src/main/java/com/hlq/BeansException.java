package com.hlq;

/**
 * @program: BaseException
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-11 14:39
 **/

public class BeansException extends Exception{

    public BeansException(String instantiationOfBeanFailed, ReflectiveOperationException e) {
    }

    public BeansException(String instantiationOfBeanFailed) {
    }
}

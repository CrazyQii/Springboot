package com.hlq.factory.partern.factory.adapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @program: JDKProxy
 * @description:
 * @author: hanLinQi
 * @create: 2022-02-28 09:37
 **/

public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter iCacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(iCacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }
}

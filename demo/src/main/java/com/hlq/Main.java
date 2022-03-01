package com.hlq;

/**
 * @program: Main
 * @description: 启动类
 * @author: hanLinQi
 * @create: 2021-12-08 17:58
 **/

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
    }
}

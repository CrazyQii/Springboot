package com.hlq.service;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @program: CallableThread
 * @description:
 * @author: hanLinQi
 * @create: 2022-04-19 11:24
 **/

public class CallableThread implements Callable<String> {

    private String command;

    public CallableThread(String command) {
        this.command = command;
    }

    @Override
    public String call() throws Exception {
        Thread.currentThread().setName(this.command + " - " + Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName() + " start time = " + new Date());
        io(this.command);
        System.out.println(Thread.currentThread().getName() + " ======== end time = " + new Date());
        return Thread.currentThread().getName() + "测试";
    }

    public void io(String s) {
        try {
            if ("7".equals(s)) {
                Thread.sleep(100000);
            }
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

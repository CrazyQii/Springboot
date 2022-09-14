package com.hlq.service;

import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: CoreThread
 * @description:
 * @author: hanLinQi
 * @create: 2022-04-18 18:24
 **/

public class RunnableThread implements Runnable {

    private String command;

    public RunnableThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.command + " - " + Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName() + " start time = " + new Date());
        io(this.command);
        System.out.println(Thread.currentThread().getName() + " ======== end time = " + new Date());
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

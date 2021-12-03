package com.hlq.thread;

import java.util.Date;

/**
 * @program: SimpleThread
 * @description: 线程任务
 * @author: hanLinQi
 * @create: 2021-12-02 17:07
 **/

public class SimpleThread implements Runnable {

    private final String command;

    public SimpleThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start time = " + new Date());
    }

    @Override
    public String toString() {
        return "SimpleThread{" +
                "command='" + command + '\'' +
                '}';
    }
}

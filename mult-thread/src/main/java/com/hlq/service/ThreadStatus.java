package com.hlq.service;

/**
 * @program: ThreadStatus
 * @description:
 * @author: hanLinQi
 * @create: 2022-04-15 16:20
 **/

public class ThreadStatus extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("开始运行");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStatus threadStatus = new ThreadStatus();
        threadStatus.start();
        threadStatus.setName("1号线程");


        System.out.println("线程唯一标识: " + threadStatus.getId());
        System.out.println("线程名称: " + threadStatus.getName());
        System.out.println("线程状态: " + threadStatus.getState());
        System.out.println("线程优先级: " + threadStatus.getPriority());

    }
}

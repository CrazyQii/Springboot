package com.hlq.service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LockService
 * @description:
 * @author: hanLinQi
 * @create: 2022-04-18 08:46
 **/

public class LockService implements Runnable {

    int a = 0;

    @Override
    public void run() {
        write();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        read(Thread.currentThread().getName());
    }

    ReentrantLock lock = new ReentrantLock();

    public void write() {
        lock.lock();  // 获取锁
        try {
            a++;
        } finally {
            lock.unlock(); // 释放锁
        }

    }

    public void read(String s) {
        lock.lock(); // 获取锁
        try {
            System.out.println(a + " " + s);
        } finally {
            lock.unlock(); // 释放锁
        }

    }
}

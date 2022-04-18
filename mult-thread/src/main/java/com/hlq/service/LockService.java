package com.hlq.service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LockService
 * @description:
 * @author: hanLinQi
 * @create: 2022-04-18 08:46
 **/

public class LockService {

    int a = 0;

    ReentrantLock lock = new ReentrantLock();

    public void write() {
        lock.lock();  // 获取锁
        try {
            a++;
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public void read() {
        lock.lock(); // 获取锁
        try {
            System.out.println(a);
        } finally {
            lock.unlock(); // 释放锁
        }
    }
}

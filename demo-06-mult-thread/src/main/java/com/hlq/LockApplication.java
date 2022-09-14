package com.hlq;

import com.hlq.service.LockService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: LockApplication
 * @description:
 * @author: hanLinQi
 * @create: 2022-04-19 14:16
 **/

public class LockApplication {

    private static final int CORE_SIZE = 2; // 核心数
    private static final int MAX_SIZE = 3; // 最大线程数
    private static final Long KEEP_ALIVE = 1L; // 等待时间
    private static final int QUEUE_CAPACITY = 100; // 队列容量

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_SIZE,
                MAX_SIZE,
                KEEP_ALIVE,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.AbortPolicy()
        );

        LockService lock = new LockService();


        for (int i = 0; i < 10; i++) {
            executor.execute(lock);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}

        System.out.println("executor finished");
    }
}

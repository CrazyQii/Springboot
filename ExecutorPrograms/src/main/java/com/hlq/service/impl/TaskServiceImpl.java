package com.hlq.service.impl;

import com.hlq.service.TaskService;
import com.hlq.thread.SimpleThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: taskServiceImpl
 * @description: 并发编程
 * @author: hanLinQi
 * @create: 2021-12-02 14:24
 **/
@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    ThreadPoolExecutor executor;


    public TaskServiceImpl() {
         this.executor = new ThreadPoolExecutor(
                // 核心线程数
                CORE_POOL_SIZE,
                // 最大线程数
                MAX_POOL_SIZE,
                // 等待时间
                KEEP_ALIVE_TIME,
                // 等待时间的单位
                TimeUnit.SECONDS,
                // 任务队列容量
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                // 饱和策略
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public void start() {
        for (int i = 0; i < 10; i++) {
            // 创建SimpleThread对象，该对象实现了Runnable接口
            Runnable runnable = new SimpleThread("" + i);
            executor.execute(runnable);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            LOGGER.info("线程未全部结束");
        }
        LOGGER.info("线程全部执行完毕");
    }
}

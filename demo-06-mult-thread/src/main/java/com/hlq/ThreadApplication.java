package com.hlq;

import com.hlq.service.CallableThread;
import com.hlq.service.RunnableThread;

import java.util.concurrent.*;

/**
 * @program: ThreadApplication
 * @description:
 * @author: hanLinQi
 * @create: 2022-04-15 16:18
 **/

public class ThreadApplication {

    private static final int CORE_SIZE = 2; // 核心数
    private static final int MAX_SIZE = 3; // 最大线程数
    private static final Long KEEP_ALIVE = 1L; // 等待时间
    private static final int QUEUE_CAPACITY = 5; // 队列容量

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_SIZE,
                MAX_SIZE,
                KEEP_ALIVE,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 10; i++) {
            Callable<String> work = new CallableThread(String.valueOf(i));
            System.out.println(executor.submit(work).get());
//            Runnable work = new RunnableThread(String.valueOf(i));
//            executor.execute(work);
        }

        // 终止线程
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}

package me.lzb.java.basic.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lzb on 19/8/15
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        int n = 10;

        CountDownLatch doneSignal = new CountDownLatch(n);
        ExecutorService e = Executors.newFixedThreadPool(8);

        // 创建 N 个任务，提交给线程池来执行
        for (int i = 0; i < n; ++i) // create and start threads
            e.execute(() -> {
                System.out.printf("[%s]执行结束\n", Thread.currentThread().getName());
                doneSignal.countDown();
            });

        // 等待所有的任务完成，这个方法才会返回
        doneSignal.await();
        System.out.printf("[%s]执行结束\n", Thread.currentThread().getName());
        e.shutdownNow();
    }


}

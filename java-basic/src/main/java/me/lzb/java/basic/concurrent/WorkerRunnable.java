package me.lzb.java.basic.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author LZB
 */
public class WorkerRunnable implements Runnable {
    private final CountDownLatch doneSignal;
    private final int i;

    WorkerRunnable(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }

    public void run() {
        doWork(i);
        // 这个线程的任务完成了，调用 countDown 方法
        doneSignal.countDown();
    }

    void doWork(int i) {
        System.out.println(i);
    }
}


package me.lzb.algroithm.Interview;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by egan on 19/9/11
 */
public class InterviewQuestions {
    /**
     * 1.编写一个程序，用两个线程打印1-100
     * 2. 编写一个demo，模拟3个售票窗口售卖100张票，第一个窗口卖一张票需要3秒，第二个窗口卖一张票需要5秒，第三个窗口卖一张票需要7秒
     * 3. 某停车场(Parklot)有停车位(ParkingSpace)若干：
     * -有一个入口和一个出口，入口完成扫描计时，出口完成结账及车位释放。
     * -停车位包含两类：货车位和小车位，货车按每小时10元计价，每天最高累计120元，小车位按每小时5元计价，每天最高累计60元。
     * -请注意提示剩余车位信息
     * 为该停车场设计一个管理系统，还原该场景，功能包括：（1）车辆进入处理（2）车辆离开处理（3）计算当日停车场缴费总金额 等。
     */
    AtomicInteger atomicInteger = new AtomicInteger();

    private volatile int a = 0;

    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        InterviewQuestions q = new InterviewQuestions();
        Thread t1 = q.getAPrintThread("T1");
        Thread t2 = q.getAPrintThread("T2");
        t1.start();
        t2.start();

        while (true) {
            if (q.a > 100) {
                t1.interrupt();
                t2.interrupt();
                break;
            }
        }
    }


    private Thread getAPrintThread(String threadName) {

        return new Thread(() -> {
            while (!Thread.interrupted()) {
                lock.lock();
                int i = this.a + 1;
                this.a = i;
                lock.unlock();
                if (i > 100) {
//                    return;
                } else {
                    System.out.println(i + "===" + Thread.currentThread().getName());
                }
            }
            System.out.println("中断了===" + Thread.currentThread().getName());
        }, threadName);
    }

}

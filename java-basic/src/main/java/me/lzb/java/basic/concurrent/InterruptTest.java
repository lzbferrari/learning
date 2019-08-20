package me.lzb.java.basic.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by egan on 19/8/16
 */
public class InterruptTest {

    private static AtomicInteger ac = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            //需求，无限睡眠,每次睡眠一千次,可以中断睡眠,在发出中断操作后睡满当前的一千次之后中断(被中断的睡眠不算一次)
            while (!Thread.interrupted()) {
                System.out.println("新的风暴已经来临");
//                wrong();
                right();
                ac.set(0);
            }
            System.out.println("我被中断了");
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            t1.interrupt();
        });
        t2.start();
    }

    //虚假的处理方式,无法中断，疯狂打印
    public static void wrong() {
        while (true) {
            try {
                if (!sleep()) {
                    //睡饱了
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("catch InterruptedException");
                Thread.currentThread().interrupt();
            }
        }
    }

    //真正的处理方式,正确中断，只打印一次
    public static void right() {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    if (!sleep()) {
                        break;
                    }
                } catch (InterruptedException e) {
                    System.out.println("catch InterruptedException");
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static boolean sleep() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1L);
        if (ac.getAndIncrement() == 1000) {
            return false;
        } else {
            return true;
        }
    }

}

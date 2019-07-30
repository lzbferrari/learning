package me.lzb.other.test;

import java.util.concurrent.TimeUnit;

/**
 * Created by egan on 19/7/29
 */
class MyTask {
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            print();
        }).start();
        Thread.sleep(2500);
        flag = false;
        System.out.println("flag set to false");
    }

    private static void print() {
        while (flag) {
        }
    }
}
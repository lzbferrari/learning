package me.lzb.java.basic.reference;

import java.util.concurrent.Executors;

/**
 * @author LZB
 */
public class ReferenceTest {

    public static void main(String[] args) {
        for (int i = 0; i < 2000; i++) {
            newSingleThreadPool();
        }
        
    }

    private static void newSingleThreadPool() {
        Executors.newSingleThreadExecutor().submit(new Runnable() {
            @Override
            public void run() {
                byte[] bytes = new byte[1024 * 1024 * 4];
                System.out.println(Thread.currentThread().getName());
            }
        });
    }

}

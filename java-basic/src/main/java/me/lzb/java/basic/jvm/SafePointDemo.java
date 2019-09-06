package me.lzb.java.basic.jvm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个线程会不会出现这种情况，不在安全区域内，然后也一直执行不到安全点，比如死循环，然后辣鸡回收就开始不了了？
 * jvm配置  -Xmx40m -XX:+PrintGCDetails
 * 这种情况写不出来
 * Created by egan on 19/9/2
 */
public class SafePointDemo {

    public static final Map<String, Object> map = new HashMap<>();
    public static char c = '1';
    public static Object b = null;
    public static void main(String[] args) throws IOException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Object a = new Object();
                while (c == '1') {
                    a = new Object();
                }
                b = a;
            }
        }, "loop");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    map.put(String.valueOf(i), new Object());
                }
                map.put(String.valueOf(Math.random()), b);
            }
        }, "create");

        t1.start();
        t2.start();

        c = (char)System.in.read();
        System.out.println(c);
    }

}

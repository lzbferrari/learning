package me.lzb.java.basic.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author LZB
 */
public class TPDemo {

    private static Executor executor = Executors.newScheduledThreadPool(100);
}

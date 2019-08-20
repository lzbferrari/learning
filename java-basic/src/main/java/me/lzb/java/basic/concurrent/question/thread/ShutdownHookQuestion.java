package me.lzb.java.basic.concurrent.question.thread;

public class ShutdownHookQuestion {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        runtime.addShutdownHook(new Thread(ShutdownHookQuestion::action, "Shutdown Hook Question"));

    }

    private static void action() {
        System.out.printf("线程[%s] 正在执行...\n", Thread.currentThread().getName());  // 2
    }
}

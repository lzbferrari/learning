package me.lzb.other.aop.normal;

public class HelloWorldProxy extends HelloWorld {
    HelloWorld hw;

    HelloWorldProxy(HelloWorld hw) {
        this.hw = hw;
    }

    public void sayHello() {
        Logger.startLog();
        hw.sayHello();
        Logger.endLog();
    }
}

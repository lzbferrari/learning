package me.lzb.other.aop.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {


    public static void main(String[] args) {

        IHelloWorld hw = new HelloWorld();

        Handler handler = new Handler(hw);

        IHelloWorld proxy = (IHelloWorld) Proxy.newProxyInstance(
            Thread.currentThread().getContextClassLoader(),
            hw.getClass().getInterfaces(), handler);

        proxy.sayHello();
    }
}
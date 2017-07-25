package me.lzb.other.aop.cglib;


import net.sf.cglib.proxy.Enhancer;


public class CGLibTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloWorld.class);
        enhancer.setCallback(new LoggerMethodInterceptor());
        HelloWorld hello = (HelloWorld) enhancer.create();
        hello.sayHello();


    }


}

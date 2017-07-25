package me.lzb.other.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {


    private Object target;

    public Handler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Logger.startLog();
        Object result = method.invoke(target, args);
        Logger.endLog();
        return result;
    }

}
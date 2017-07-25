package me.lzb.other.aop.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LoggerMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (method.getName().equals("sayHello")) {
            Logger.startLog();
            proxy.invokeSuper(obj, args);
            Logger.endLog();
        }
        return null;
    }
}

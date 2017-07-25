package me.lzb.other.aop.liteaop1;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.lang.reflect.Method;

public class AOPTest {

    public static void main(String[] args) throws Exception {
        ClassReader cr = new ClassReader("me.lzb.other.aop.liteaop1.HelloWorld");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        cr.accept(new LoggerClassVisitor(cw), ClassReader.SKIP_DEBUG);
        byte[] byteCodes = cw.toByteArray();


        Class<?> clazz = new MyClassLoader().defineClassForName(
            "me.lzb.other.aop.liteaop1.HelloWorld$EnhancedByASM",
            byteCodes);

        Object obj = clazz.newInstance();
        Method m = clazz.getDeclaredMethods()[0];
        m.invoke(obj);

    }

}

class MyClassLoader extends ClassLoader {
    public MyClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
    }

    public Class<?> defineClassForName(String name, byte[] data) {
        return this.defineClass(name, data, 0, data.length);
    }
}

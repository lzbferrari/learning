package me.lzb.other.aop.liteaop;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.lang.reflect.Method;

public class AOPTest {

    public static void main(String[] args) throws Exception {
        ClassReader reader = new ClassReader("me.lzb.other.aop.liteaop.HelloWorld");
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor visitor = new LoggerClassVisitor(writer);
        reader.accept(visitor, ClassReader.SKIP_DEBUG);
        byte[] byteCodes = writer.toByteArray();

        Class<?> clazz = new MyClassLoader().defineClassForName(
            "me.lzb.other.aop.liteaop.HelloWorld",
            byteCodes);

        Object obj = clazz.newInstance();
        Method m = clazz.getDeclaredMethods()[0];
        m.invoke(obj);



        /*byte[] data = cw.toByteArray();
        File file = new File("D:\\code\\learning\\tmp\\HelloWorld.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();*/

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

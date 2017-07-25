package me.lzb.other.aop.liteaop;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class LoggerClassVisitor extends ClassVisitor {

    public LoggerClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {

        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if ("sayHello".equals(name)) {
            return new LoggerMethodVisitor(mv);
        }
        return mv;

    }
}


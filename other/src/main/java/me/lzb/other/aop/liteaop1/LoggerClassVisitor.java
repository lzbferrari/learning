package me.lzb.other.aop.liteaop1;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class LoggerClassVisitor extends ClassVisitor {
    private String superClassName;

    public LoggerClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    public void visit(int version, int access, String name, String signature,
                      String superName, String[] interfaces) {
        //name 为"HelloWorld"
        String enhancedName = name + "$EnhancedByASM";
        superClassName = name;
        super.visit(version, access, enhancedName, signature, superClassName, interfaces);
    }

    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {

        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if ("sayHello".equals(name)) {
            return new LoggerMethodVisitor(mv);
        } else if ("<init>".equals(name)) {
            return new ChangeConstructorVisitor(mv,
                superClassName);
        }
        return mv;

    }

}

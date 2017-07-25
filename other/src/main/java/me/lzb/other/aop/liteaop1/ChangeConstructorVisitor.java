package me.lzb.other.aop.liteaop1;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ChangeConstructorVisitor extends MethodVisitor {
    private String superClassName;

    public ChangeConstructorVisitor(MethodVisitor mv,
                                    String superClassName) {

        super(Opcodes.ASM5, mv);
        this.superClassName = superClassName;
    }

    public void visitMethodInsn(int opcode, String owner, String name,
                                String desc, boolean itf) {

        if (opcode == Opcodes.INVOKESPECIAL && name.equals("<init>")) {
            owner = superClassName;
        }
        super.visitMethodInsn(opcode, owner, name, desc, itf);
    }

}

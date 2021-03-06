package me.lzb.other.aop.liteaop;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class LoggerMethodVisitor extends MethodVisitor {

    public LoggerMethodVisitor(MethodVisitor mv) {
        super(Opcodes.ASM5, mv);
    }

    public void visitCode() {
        super.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "me/lzb/other/aop/liteaop/Logger",
            "startLog",
            "()V",
            false);
        super.visitCode();
    }

    public void visitInsn(int opcode) {
        if (opcode == Opcodes.RETURN) {
            super.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "me/lzb/other/aop/liteaop/Logger",
                "endLog",
                "()V",
                false);
        }
        super.visitInsn(opcode);
    }
}

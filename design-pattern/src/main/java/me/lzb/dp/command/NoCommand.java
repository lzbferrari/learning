package me.lzb.dp.command;

public class NoCommand implements Command {
    public void execute() {
        System.out.println("没有命令");
    }

    public void undo() {
        System.out.println("没有命令");
    }
}

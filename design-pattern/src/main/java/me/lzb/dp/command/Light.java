package me.lzb.dp.command;

public class Light {
    String location;
    int level;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        level = 100;
        System.out.println("电灯开");
    }

    public void off() {
        level = 0;
        System.out.println("电灯关");
    }

    public void dim(int level) {
        this.level = level;
        if (level == 0) {
            off();
        } else {
            System.out.println("电灯变暗到" + level + "%");
        }
    }

    public int getLevel() {
        return level;
    }
}

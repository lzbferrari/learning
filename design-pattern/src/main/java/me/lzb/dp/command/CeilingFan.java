package me.lzb.dp.command;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
    }

    public void high() {
        // 最高档
        speed = HIGH;
        System.out.println(location + " 电风扇最高档");
    }

    public void medium() {
        // 中间档
        speed = MEDIUM;
        System.out.println(location + " 电风扇中间档");
    }

    public void low() {
        // 调到最低档
        speed = LOW;
        System.out.println(location + " 电风扇最低档");
    }

    public void off() {
        // 关闭电风扇
        speed = OFF;
        System.out.println(location + " 电风扇关闭");
    }

    public int getSpeed() {
        return speed;
    }
}

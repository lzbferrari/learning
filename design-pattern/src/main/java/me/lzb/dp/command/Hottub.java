package me.lzb.dp.command;

public class Hottub {
    boolean on;
    int temperature;

    public Hottub() {
    }

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    public void circulate() {
        if (on) {
            System.out.println("热水浴缸正在冒泡!");
        }
    }

    public void jetsOn() {
        if (on) {
            System.out.println("热水浴缸在喷气");
        }
    }

    public void jetsOff() {
        if (on) {
            System.out.println("热水浴缸不在喷气");
        }
    }

    public void setTemperature(int temperature) {
        if (temperature > this.temperature) {
            System.out.println("热水浴缸在加热到" + temperature + "度");
        } else {
            System.out.println("热水浴缸在冷却到" + temperature + "度");
        }
        this.temperature = temperature;
    }
}

package me.lzb.other.initialization;

/**
 * @author LZB
 */
public class Son extends Father {


    public static String sonStaticField = ssf();

    public String sonField = sf();

    static {
        System.out.println("子类静态块");
    }

    {
        System.out.println("子类普通块");
    }

    public Son() {
        System.out.println("子类构造方法");
    }


    private static String ssf() {
        System.out.println("子类静态变量");
        return "子类静态变量";
    }

    private String sf() {
        System.out.println("子类变量");
        return "子类变量";
    }
}

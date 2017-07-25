package me.lzb.other.initialization;

/**
 * @author LZB
 */
public class Father {

    public static String fatherStaticField = fsf();

    public String fatherField = ff();

    static {
        System.out.println("父类静态块");
    }

    {
        System.out.println("父类普通块");
    }

    public Father() {
        System.out.println("父类构造方法");
    }


    private static String fsf() {
        System.out.println("父类静态变量");
        return "父类静态变量";
    }

    private String ff() {
        System.out.println("父类变量");
        return "父类变量";
    }
}

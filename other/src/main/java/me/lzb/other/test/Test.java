package me.lzb.other.test;

/**
 * @author LZB
 */
public class Test {
    public static void main(String[] args) {

        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        boolean bb = a == b;
        System.out.println(bb);


    }
}

package me.lzb.other.test;

import java.math.BigDecimal;

/**
 * Created by egan on 19/7/29
 */
public class Test {

    public static void main(String[] args) {


        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("2");
        BigDecimal c = new BigDecimal("3");
        BigDecimal d = new BigDecimal("2");
        System.out.println(b.compareTo(a));
        System.out.println(b.compareTo(c));
        System.out.println(b.compareTo(d));

    }





}

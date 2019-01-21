package me.lzb.algroithm.leetcode.n190;

import org.junit.Assert;

/**
 * @author LZB
 */
public class Solution {
    /**
     * 思路：
     * 初始1101= 1*2^3 + 1*2^2 + 0*2^1 + 1*2^0 --倒过来--> 1*2^0 + 1*2^1 + 0*2^2 + 1*2^3
     *
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        final int length = 32;
        int r = 0;//结果
        int i = 1;//循环的次数，表示当前是在第几位
        int x;//取余的结果
        while (n > 0) {
            x = n % 2;
            n = n / 2;
            if (x == 1) {
                r = r + (int) Math.pow(2, length - i);
            }
            i++;
        }
        return r;

    }


    public static void main(String[] args) {
//        String s = "11111111111111111111111111111101";
//        System.out.println(s.length());
//        int a = 0;
//        for (int i = 0; i < s.length(); i++) {
//            a = a + (Integer.parseInt(String.valueOf(s.charAt(i))) * (int) Math.pow(2, s.length() - i - 1));
//        }
//
//        int after = reverseBits(a);
//        System.out.println(a);
//        System.out.println(after);




        int after = reverseBits(43261596);
        Assert.assertEquals(964176192, after);
    }

}

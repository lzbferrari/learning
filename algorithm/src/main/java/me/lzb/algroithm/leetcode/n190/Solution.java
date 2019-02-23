package me.lzb.algroithm.leetcode.n190;

import org.junit.Assert;

/**
 * 颠倒二进制位
 * @author LZB
 */
class Solution {
    /**
     * 思路：
     * 初始1101= 1*2^3 + 1*2^2 + 0*2^1 + 1*2^0 --倒过来--> 1*2^0 + 1*2^1 + 0*2^2 + 1*2^3
     * 思路是对的，但是特么不是很正规，也无法解决符号位问题
     *
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        //这个不能处理无符号数
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

    /**
     * 利用位移，取n的最后一位，填充r的最后一位，n右移，r左移
     *
     * @param n
     * @return
     */
    public static int reverseBits2(int n) {
        final int length = 32;
        int r = 0;
        for (int i = 0; i < length; i++) {
            //左移一位
            r = r << 1;
            //n的最后一位和1进行与运算，得出r的最后一位值，加上去
            r = r + (n & 1);
            //循环32次，n每次右移一位
            n = n >> 1;
        }
        return r;
    }

    /**
     * 抄的，看不懂
     *
     * @param n
     * @return
     */
    public int reverseBits3(int n) {
        n = (n << 16) | (n >>> 16);
        n = ((n & 0x00ff00ff) << 8) | ((n & 0xff00ff00) >>> 8);
        n = ((n & 0x0f0f0f0f) << 4) | ((n & 0xf0f0f0f0) >>> 4);
        n = ((n & 0x33333333) << 2) | ((n & 0xcccccccc) >>> 2);
        n = ((n & 0x55555555) << 1) | ((n & 0xaaaaaaaa) >>> 1);
        return n;
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-3).toCharArray());

        int after = reverseBits2(-3);
        Assert.assertEquals(-1073741825, after);
    }

}

package me.lzb.common.utils;

/**
 * @author LZB
 */
public class OtherUtils {

    /**
     * 获取一个数的位数
     *
     * @param i
     * @return
     */
    public static int getDigit(int i) {
        int a = i;
        int c = 0;
        while (a > 0) {
            a = a / 10;
            c++;
        }
        return c;
    }

    public static long[] cutTail(long[] source, int cutLength){
        long[] r = new long[cutLength];
        System.arraycopy(source, source.length - cutLength, r, 0, cutLength);
        return r;
    }

}

package me.lzb.algroithm.topk;

import me.lzb.common.utils.OtherUtils;

/**
 * Created by lzb on 19/1/21
 */
public class TopkQuicksort {


    public static long[] getTopK(long[] a, int k) {
        sort(a, 0, a.length - 1, k);
        return OtherUtils.cutTail(a, k);
    }


    private static void sort(long[] a, int lo, int hi, int k) {
        if (hi <= lo) {
            return;
        }

        int j = partition(a, lo, hi);

        if (j < k) {
            sort(a, j + 1, hi, k);
        } else {
            sort(a, j + 1, hi, k);
            sort(a, lo, j - 1, k);
        }
    }

    private static int partition(long[] a, int lo, int hi) {

        int i = lo;
        int j = hi;
        //切分元素就选数组头部的元素
        long v = a[lo];

        while (i != j) {
            //先从右边找一个放到左边
            while (j > i) {
                if (a[j] < v) {
                    a[i] = a[j];
                    break;
                }
                j--;
            }
            //再从左边找一个放到右边
            while (i < j) {
                if (a[i] > v) {
                    a[j] = a[i];
                    break;
                }
                i++;
            }
        }

        a[i] = v;
        return i;


    }


}

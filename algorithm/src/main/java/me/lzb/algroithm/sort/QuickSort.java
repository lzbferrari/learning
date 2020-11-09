package me.lzb.algroithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 1.在待排序的元素任取一个元素作为基准(通常选第一个元素，但最的选择方法是从待排序元素中随机选取一个作为基准)，称为基准元素；
 * 2.将待排序的元素进行分区，比基准元素大的元素放在它的右边，比其小的放在它的左边；
 * 3.对左右两个分区重复以上步骤直到所有元素都是有序的。
 * https://www.cnblogs.com/MOBIN/p/4681369.html
 *
 * @author LZB
 */
public class QuickSort {


    public static void sort(int[] array, int left, int right) {
        //当左右坐标相等时，退出递归
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;


        //partition选最左边的，最左边的位置空了出来
        int p = array[l];

        while (l != r) {
            //因为partition是最左边的，所以先从右边找到一个小于partition的放到左边
            while (r > l) {
                if (array[r] < p) {
                    array[l] = array[r];
                    break;

                } else {
                    r--;
                }
            }
            //再从左边选出一个大于partition的放到右边
            while (l < r) {
                if (array[l] > p) {
                    array[r] = array[l];
                    break;
                } else {
                    l++;
                }
            }
        }
        //一直循环，直到左右坐标相等

        //把最早取出来的partition放到左右相等的坐标
        array[l] = p;
        //这时，左边的数字都比partition小，右边的数字都比partition大

        //对当前partition左边的数字排序
        sort(array, left, l - 1);

        //对当前partition右边的数字排序
        sort(array, l + 1, right);

    }

    public static void main(String[] args) {
        int[] array = {2, 5, 4, 3, 7, 8, 1, 9, 0, 10, 6};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}

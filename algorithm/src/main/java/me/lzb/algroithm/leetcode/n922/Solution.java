package me.lzb.algroithm.leetcode.n922;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * Created by lzb on 19/4/30
 */
class Solution {


    public int[] sortArrayByParityII(int[] A) {
        if (A.length <= 1) {
            return A;
        }

//        sort(A, 0, A.length - 1);

        int[] r = new int[A.length];

        int oddIdx = 1;

        int evenIdx = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                //奇数
                r[oddIdx] = A[i];
                oddIdx = oddIdx + 2;
            } else {
                r[evenIdx] = A[i];
                evenIdx = evenIdx + 2;
            }
        }

        return r;
    }

    private void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(array, left, right);
        sort(array, left, p - 1);
        sort(array, p + 1, right);
    }


    private int partition(int[] array, int left, int right) {

        //从左边选一个partition
        int v = array[left];


        while (left < right) {

            while (right > left) {
                if (array[right] < v) {
                    array[left] = array[right];
                    break;
                }
                right--;
            }


            while (left < right) {
                if (array[left] > v) {
                    array[right] = array[left];
                    break;
                }

                left++;
            }
        }
        array[left] = v;
        return left;
    }


    public static void main(String[] args) {
        int[] a = {4, 2, 5, 7};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sortArrayByParityII(a)));

    }

}

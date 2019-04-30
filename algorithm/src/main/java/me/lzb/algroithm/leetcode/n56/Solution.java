package me.lzb.algroithm.leetcode.n56;

import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * Created by LZB on 19/4/30
 */
class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return new int[0][0];
        }

        if (intervals.length <= 1) {
            return intervals;
        }

        sort(intervals, 0, intervals.length - 1);

        int[][] result = new int[intervals.length][2];
        result[0] = intervals[0];

        //当前空着的
        int idxR = 1;

        for (int i = 1; i < intervals.length; i++) {
            int[] left = result[idxR - 1];
            int[] right = intervals[i];

            //判断是否要合并
            if (left[1] >= right[0]) {
                result[idxR - 1][1] = right[1] > left[1] ? right[1] : left[1];
                result[idxR - 1][0] = right[0] < left[0] ? right[0] : left[0];
            } else {
                result[idxR] = right;
                idxR = idxR + 1;
            }
        }

        if (idxR >= result.length) {
            return result;
        }


        int[][] r = new int[idxR][2];
        System.arraycopy(result, 0, r, 0, idxR);
        return r;

    }


    //根据区间左侧的坐标大小，对区间排序
    private void sort(int[][] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, j + 1, hi);
        sort(a, lo, j - 1);
    }

    private int partition(int[][] a, int lo, int hi) {

        int i = lo;
        int j = hi;
        //切分元素就选数组头部的元素
        int[] v = a[lo];

        while (i != j) {
            //先从右边找一个放到左边
            while (j > i) {
                if (a[j][0] < v[0]) {
                    a[i] = a[j];
                    break;
                }
                j--;
            }
            //再从左边找一个放到右边
            while (i < j) {
                if (a[i][0] > v[0]) {
                    a[j] = a[i];
                    break;
                }
                i++;
            }
        }
        a[i] = v;
        return i;
    }


    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.merge(a)));

    }

}

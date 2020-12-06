package me.lzb.algroithm.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * Created by lzb on 19/1/23
 */
class Solution53 {

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int s = nums[i];

            tmp[i] = s;
            for (int j = i + 1; j < nums.length; j++) {
                int s2 = s + nums[j];
                tmp[j] = s2;
                s = s2;
            }

            for (int j = i; j < nums.length; j++) {
                if (tmp[j] > s) {
                    s = tmp[j];
                }
            }

            if (s > sum) {
                sum = s;
            }
        }

        return sum;
    }


    public static int maxSubArray2(int[] nums) {
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int s = nums[i];
            if (s > sum) {
                sum = s;
            }
            for (int j = i + 1; j < nums.length; j++) {
                s = s + nums[j];
                if (s > sum) {
                    sum = s;
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] array = {-1, 0, -2};

        int sum = maxSubArray(array);
        System.out.println(sum);

    }
}

package me.lzb.algroithm.leetcode.n1;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * Created by lzb on 19/1/22
 */
class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] r = new int[2];

        int index = 0;
        while (index < nums.length - 1){
            boolean find = false;
            int a = nums[index];
            for (int i = index + 1; i < nums.length; i++) {
                int sum = a + nums[i];
                if(sum == target){
                    find = true;
                    r[0] = index;
                    r[1] = i;
                    break;
                }
            }

            if(find){
                break;
            }

            index = index + 1;
        }


        return r;
    }

}

package me.lzb.algroithm.leetcode.n300;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by egan on 19/7/4
 */
class Solution {

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] xx = new int[nums.length];
        int r = 1;
        int minStart = nums[0];
        for (int j = 0; j < nums.length; j++) {
            if (nums.length - j < r) {
                break;
            }
            if (nums[j] >= minStart) {
                continue;
            } else {
                minStart = nums[j];
            }
            xx[0] = nums[j];
            int idx = 0;

            for (int i = j; i < nums.length; i++) {
                if (idx == 0) {
                    if (nums[i] < xx[idx]) {
                        xx[idx] = nums[i];
                    }
                    if (nums[i] > xx[idx]) {
                        idx = idx + 1;
                        xx[idx] = nums[i];
                    }
                } else {
                    if (nums[i] < xx[idx] && nums[i] > xx[idx - 1]) {
                        xx[idx] = nums[i];
                    }

                    if (nums[i] > xx[idx]) {
                        idx = idx + 1;
                        xx[idx] = nums[i];
                    }
                }
            }
            idx = idx + 1;
            if (r < idx) {
                r = idx;
            }
        }
        return r;
    }


    /**
     * 贪心加二分
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] xx = new int[nums.length];
        xx[0] = nums[0];
        int idx = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > xx[idx]) {
                idx = idx + 1;
                xx[idx] = nums[i];
            }

            if (nums[i] < xx[idx]) {

                int low = 0;
                int high = idx;
                int mid;
                while (low <= high) {
                    mid = low + (high - low) / 2;
                    if (xx[mid] == nums[i]) {
                        break;
                    }


                    if (mid <= 0) {
                        if (xx[0] > nums[i]) {
                            xx[0] = nums[i];
                            break;
                        }
                    }

                    if (mid >= idx) {
                        if (xx[idx] > nums[i]) {
                            xx[idx] = nums[i];
                            break;
                        }
                    }


                    if (xx[mid] > nums[i]) {
                        if (xx[mid - 1] < nums[i]) {
                            xx[mid] = nums[i];
                            break;
                        }
                        high = mid - 1;
                    }

                    if (xx[mid] < nums[i]) {
                        if (xx[mid + 1] > nums[i]) {
                            xx[mid + 1] = nums[i];
                            break;
                        }
                        low = mid + 1;
                    }

                }

            }
        }
        return idx + 1;
    }


    public static void main(String[] args) {
        int[] xx = {1, 3, 6, 7, 9, 4, 10, 5, 6};
//        int[] xx = {3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
//        int[] xx = {3, 2, 1};
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS2(xx));
    }
}

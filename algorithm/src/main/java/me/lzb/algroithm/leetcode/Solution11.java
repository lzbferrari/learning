package me.lzb.algroithm.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * @author LZB
 */
class Solution11 {


    /**
     * 从两边向中间遍历，每次都把短的那条的坐标，往长的那边靠拢
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        while (r > l) {
            boolean moveLeft = height[l] < height[r];
            int len = r - l;

            int h = height[l] > height[r] ? height[r] : height[l];
            int a = len * h;

            if (a > area) {
                area = a;
            }
            if (moveLeft) {
                l = l + 1;
            } else {
                r = r - 1;
            }
        }
        return area;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(a));
    }

}

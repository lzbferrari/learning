package me.lzb.algroithm.leetcode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @author LZB
 */
class Solution42 {

    /**
     * 分治
     * 以1为单位分层，独立计算每个高度下积累的雨水，最后加起来就行
     *
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        int sum = 0;
        boolean loop = true;
        int h = 1;
        while (loop) {
            loop = false;
            int l = -1;
            for (int i = 0; i < height.length; i++) {
                int a = height[i];
                if (a >= h) {
                    loop = true;
                    if (l >= 0) {
                        sum = sum + (i - l - 1);
                    }
                    l = i;
                }
            }
            h = h + 1;
        }
        return sum;
    }

    /**
     * trap1的改进，标记了下一层需要循环的坐标范围，但是更慢了。。。
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int sum = 0;
        boolean loop = true;
        int h = 1;
        int nextStart = 0;
        boolean findNextStart;
        int nextEnd = height.length - 1;
        while (loop) {
            loop = false;
            findNextStart = false;
            int l = -1;
            int x = nextEnd;
            for (int i = nextStart; i <= x; i++) {
                int a = height[i];
                if (a >= h) {
                    if (a > h) {
                        if (!findNextStart) {
                            findNextStart = true;
                            nextStart = i;
                        }
                        nextEnd = i;
                        loop = true;
                    }
                    if (l >= 0) {
                        sum = sum + (i - l - 1);
                    }
                    l = i;
                }
            }
            h = h + 1;
        }
        return sum;
    }

    /**
     * 分治，
     * 以最高的柱子为分界点（如果有个多个相同的最高的柱子，选最右的），把柱子分为两个数组，从起始柱子往最高的柱子遍历
     * 找到一个等高或者更高的柱子，就计算面积
     *
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        if (height.length <= 0) {
            return 0;
        }

        int sum = 0;
        //初始化最左边的柱子
        int subSum = 0;
        int tmpH = height[0];
        int tmpIdx = 0;

        //从左到右循环
        for (int i = 1; i < height.length; i++) {
            int a = height[i];

            //发现更高或者相等搞的柱子
            if (a >= tmpH) {
                //如果不是相邻的,就计算中间的积水量
                int x = i - tmpIdx - 1;
                if (x > 0) {
                    int s = tmpH * x - subSum;
                    sum = sum + s;
                    subSum = 0;
                }

                //计算完成之后替换左边的柱子
                //相邻的无法积水，直接替换
                tmpH = a;
                tmpIdx = i;

            } else {
                subSum = subSum + height[i];
            }
        }


        //初始化最右边的柱子
        int idxL = tmpIdx;

        subSum = 0;
        tmpH = height[height.length - 1];
        tmpIdx = height.length - 1;


        //再从右往左循环
        for (int i = height.length - 1; i >= idxL; i--) {
            int a = height[i];
            //发现更高或者相等搞的柱子
            if (a >= tmpH) {
                //如果不是相邻的,就计算中间的积水量
                int x = tmpIdx - i - 1;
                if (x > 0) {
                    int s = tmpH * x - subSum;
                    sum = sum + s;
                    subSum = 0;
                }
                //计算完成之后替换左边的柱子
                //相邻的无法积水，直接替换
                tmpH = a;
                tmpIdx = i;

            } else {
                subSum = subSum + height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap3(height));
    }

}

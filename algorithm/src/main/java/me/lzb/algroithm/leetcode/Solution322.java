package me.lzb.algroithm.leetcode;


/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * Created by lzb on 19/2/23
 */
class Solution322 {


    /**
     * 动态规划
     * 这道题的最小单位是1，把amount拆分成amount份，每份是1， 用当前需要凑的金额-硬币的面额=差，获取到的差的最优解，加1，就是当前面额的最优解
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //tmp[i]:存放凑i元的最优解
        int[] tmp = new int[amount + 1];

        //初始化0元的结果作为基础，为了方便理解，数组里的默认值就是0
        tmp[0] = 0;

        //从1开始，获取每一次的最优解
        for (int i = 1; i < amount + 1; i++) {
            tmp[i] = amount + 1; //初始化一个超过amount的值，amount+1个1元硬币的组合肯定大于amount，不符合条件，后面比较的时候，如果凑出来硬币，数量一定小于amount+1

            //找一个合适的硬币
            for (int c : coins) {
                //计算当前需要凑的总面值和这枚硬币的差
                int difference = i - c;

                if (difference < 0) {
                    //如果硬币的面值比当前总共要凑的钱的数额大，忽略这个硬币，用不上，辣鸡
                    continue;
                }

                //获取 差 的面额的硬币数量 加上当前的硬币，就是用这个硬币的最优解，就等于当前需要凑的面额
                //这里的 tmp[difference]是不会下标越界的，因为i-c的结果肯定在0到i直接，而小于i的最优解，都已经计算过了
                int a = tmp[difference] + 1;

                //如果这次用的硬币更少，就更新数量
                if (tmp[i] > a) {
                    tmp[i] = a;
                }
            }

        }
        //如果 tmp[amount]是初始化的值，说明没凑出来
        return tmp[amount] >= amount + 1 ? -1 : tmp[amount];
    }
}

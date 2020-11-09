package me.lzb.algroithm.leetcode.n474;

import org.junit.Test;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * <p>
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }

    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int M = m + 1;
        int N = n + 1;
        int[][][] dp = new int[strs.length + 1][M][N]; // dp[插入/不插入第i个字符串][m个1][n个0] 组合最多的字符串数量

        for (int i = 1; i < strs.length + 1; i++) {
            String str = strs[i - 1];
            int[] t = countzeroesones(str);

            int zeroCount = t[0];
            int oneCount = t[1];
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (j >= zeroCount && k >= oneCount) {
                        dp[i][j][k] = Math.max(dp[i - 1][j - zeroCount][k - oneCount] + 1, dp[i][j][k]);
                    }
                    dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i][j][k]);
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int findMaxForm3(String[] strs, int m, int n) {
        //记下每个元素对应的符合mn条件的子集个数
        int[][][] tmp = new int[strs.length + 1][m+1][n+1];


        for(int i = 1; i < strs.length + 1; i++){
            String s = strs[i - 1];
            int[] t = count(s);
            int zero = t[0];
            int one = t[1];
            for(int j = 0;j < m; j++){
                for(int k = 0; k<n;k++){
                    if(j >= zero && k >= one){
                        tmp[i][j][k] = Math.max(tmp[i][j][k], tmp[i-1][j-zero][k-one] + 1);
                    }
                    tmp[i][j][k] = Math.max(tmp[i][j][k], tmp[i-1][j][k]);
                }

            }


        }


        return tmp[strs.length][m][n];
    }


    private int[] count(String str){
        int[] t = new int[2];
        char[] chars = str.toCharArray();
        for(char c : chars){
            if( c == '0'){
                t[0] = t[0] + 1;
            }else{
                t[1] = t[1] + 1;
            }
        }
        return t;
    }

    @Test
    public void test() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int a = findMaxForm3(strs, 5, 3);
        System.out.println(a);
    }

}

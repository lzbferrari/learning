package me.lzb.algroithm.leetcode.n1025;

import org.junit.Test;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divisor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static boolean divisorGame(int N) {
        //数学归纳法归纳出来的规律，偶数先手赢，奇数先手输
        // return N % 2 == 0;
        if (N < 1) {
            return false;
        }
        boolean[] tmp = new boolean[N + 1];
        tmp[0] = false;
        tmp[1] = false;
        tmp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                //
                if (i % j == 0  //这说明能选到j这个数，且j是符合条件的
                    && !tmp[i - j] //这个说明
                ) {
                    tmp[i] = true;
                    break;
                }
            }
        }

        return tmp[N];
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(6));
        char a = '0';
        System.out.println(Integer.parseInt(String.valueOf(a)));
    }

}

package me.lzb.algroithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 * 给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 * 因此，当 n = 0 时，其格雷编码序列为 [0]。
 *
 * @author LZB
 */
class Solution89 {
    /**
     * 动态规划
     * n位就是n-1位的结果的前面加一位0，和加一位1
     *
     * @param n
     * @return
     */
    public static List<Integer> grayCode(int n) {
        int l = (int) Math.pow(2, n);
        int[] tmp1 = new int[l];
        int[] tmp2 = new int[l];
        int idx = 1;
        boolean isTmp1 = true;
        int x = 1;
        for (int i = 1; i <= n; i++) {

            if (isTmp1) {
                //tmp1转到tmp2
                build(tmp1, tmp2, idx, x);
                isTmp1 = false;
            } else {
                //tmp2转到tmp1
                build(tmp2, tmp1, idx, x);
                isTmp1 = true;
            }

            idx = idx * 2;
            x = 2 * x;
        }

        List<Integer> result = new ArrayList<>(idx);
        if (isTmp1) {
            for (int i = 0; i < idx; i++) {
                result.add(tmp1[i]);
            }
        } else {
            for (int i = 0; i < idx; i++) {
                result.add(tmp2[i]);
            }
        }
        return result;
    }

    private static void build(int[] src, int[] target, int length, int x) {
        System.arraycopy(src, 0, target, 0, length);

        int z = 0;
        for (int j = length - 1; j >= 0; j--) {
            target[length + z] = src[j] ^ x;
            z++;
        }

    }


    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }

}

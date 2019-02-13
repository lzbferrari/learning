package me.lzb.algroithm.leetcode.n5;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * Created by lzb on 19/2/13
 */
public class Solution {

    /**
     * 暴力穷举
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        char[] charArray = s.toCharArray();
        char[] tmp = new char[charArray.length];
        tmp[0] = charArray[0];
        int index = 1;

        for (int i = 0; i < charArray.length; i++) {
            char[] tmp2 = new char[charArray.length];
            tmp2[0] = charArray[i];
            int index2 = 1;
            for (int j = i + 1; j < charArray.length; j++) {
                tmp2[index2] = charArray[j];
                index2 = index2 + 1;
                if (index2 > index) {
                    if (isPalindrome(tmp2, index2)) {
                        System.arraycopy(tmp2, 0, tmp, 0, index2);
                        index = index2;
                    }
                }
            }
        }
        char[] res = new char[index];
        System.arraycopy(tmp, 0, res, 0, index);
        return String.valueOf(res);
    }


    private static boolean isPalindrome(char[] chars, int index) {
        if (index <= 1) {
            return true;
        }
        int loop = index / 2;
        for (int i = 0; i < loop; i++) {
            if (chars[i] != chars[index - 1 - i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "";
        System.out.println(longestPalindrome(s));
    }

}

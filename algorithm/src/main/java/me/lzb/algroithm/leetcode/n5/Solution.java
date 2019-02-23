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
class Solution {

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


    /**
     * 最长公共子串解法
     * 居然还是暴力法快。。。
     *
     * @param s
     * @return
     */
    public static String longestCommonSubsequence(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }

        int al = s.length();
        int bl = s.length();

        char[] a = s.toCharArray();
        //颠倒
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            b[b.length - 1 - i] = a[i];
        }

        char[] tmp = {a[0]};
        for (int i = 0; i < al + bl - 1; i++) {
            //左下角到右上角
            int l; //纵坐标
            int r;//横坐标
            int tmpL;//这次的子串长度
            if (al > i) {
                l = al - 1 - i;
                r = 0;
                tmpL = al - l;
            } else {
                l = 0;
                r = i - al;
                tmpL = bl - r;
            }
            //如果最长长度都没有当前找到的回文子串长，就跳过这次
            if (tmpL <= tmp.length) {
                continue;
            }

            //因为中间可能断掉不连续，所以两个临时数组，while循环结束后选长的；
            char[] tc1 = new char[tmpL];
            char[] tc2 = new char[tmpL];
            int idx1 = 0;//数组当前用到的坐标
            int idx2 = 0;
            boolean useTc1 = true;
            while (l < al && r < bl) {

                if (a[l] == b[r]) {
                    if (useTc1) {
                        tc1[idx1] = a[l];
                        idx1 = idx1 + 1;
                    } else {
                        tc2[idx2] = a[l];
                        idx2 = idx2 + 1;
                    }
                } else {
                    char[] tt = getCharArray(tmp.length, useTc1, tc1, idx1, tc2, idx2);
                    if(tt!= null){
                        tmp = tt;
                    }

                    if (idx2 < idx1) {
                        useTc1 = false;
                        idx2 = 0;
                    } else {
                        useTc1 = true;
                        idx1 = 0;
                    }
                }
                l = l + 1;
                r = r + 1;
                char[] tt = getCharArray(tmp.length, useTc1, tc1, idx1, tc2, idx2);
                if(tt!= null){
                    tmp = tt;
                }
            }
        }

        return String.valueOf(tmp);
    }


    private static char[] getCharArray(int tmpLength, boolean useTc1, char[] tc1, int idx1, char[] tc2, int idx2) {
        if (useTc1) {
            if (idx1 > tmpLength) {
                if (isPalindrome(tc1, idx1)) {
                    char[] cc = new char[idx1];
                    System.arraycopy(tc1, 0, cc, 0, idx1);
                    return cc;
                }
            }
        } else {
            if (idx2 > tmpLength) {
                if (isPalindrome(tc2, idx2)) {

                    char[] cc = new char[idx2];
                    System.arraycopy(tc2, 0, cc, 0, idx2);
                    return cc;
                }
            }
        }

        return null;

    }


    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestCommonSubsequence(s));
    }

}

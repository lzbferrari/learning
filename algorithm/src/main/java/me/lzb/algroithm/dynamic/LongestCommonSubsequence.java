package me.lzb.algroithm.dynamic;

import java.util.HashMap;

/**
 * 最长公共子序
 * Created by lzb on 19/2/20
 */
public class LongestCommonSubsequence {


    public static String common(String strA, String strB) {
        if (strA == null || strB == null) {
            return null;
        }

        int al = strA.length();
        int bl = strB.length();


        char[] a = strA.toCharArray();
        char[] b = strB.toCharArray();

        char[] tmp = new char[0];
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
            }

            char[] tc = new char[idx2 > idx1 ? idx2 : idx1];
            if (idx2 > idx1) {
                System.arraycopy(tc2, 0, tc, 0, idx2);
            } else {
                System.arraycopy(tc1, 0, tc, 0, idx1);
            }
            if (tc.length > tmp.length) {
                tmp = tc;
            }

        }
        return String.valueOf(tmp);
    }

//    public static void main(String[] args) {
//        String a = "cfabd";
//        String b = "caabc";
//        System.out.println(common(a, b));
//    }

    public static void main(String[] args) {
        String a = "qq";
        String b = "qq";
        StringBuilder sb = new StringBuilder();
        sb.append("qq");
        System.out.println(a == b);
        System.out.println(a == sb.toString());
        new HashMap<>(1);
    }

}

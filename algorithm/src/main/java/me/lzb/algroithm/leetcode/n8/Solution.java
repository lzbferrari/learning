package me.lzb.algroithm.leetcode.n8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by egan on 19/10/11
 */
class Solution {
    /**
     * 正则操作
     * @param str
     * @return
     */
    static int myAtoi(String str) {

        if (str == null) {
            return 0;
        }

        str = str.trim();
        if (str.length() <= 0) {
            return 0;
        }
        String regex = "^([+]|[-]|[0-9])[0-9]*";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(str);
        if (!matcher.find()) {
            return 0;
        }
        String matchStr = matcher.group();

        String head = matchStr.substring(0, 1);
        if ("+".equals(head)) {
            if (matchStr.length() <= 1) {
                return 0;
            }
            matchStr = matchStr.substring(1);
        }


        if ("-".equals(head)) {
            matchStr = matchStr.replaceAll("^[-][0]*", "-");
            if (matchStr.length() <= 1) {
                return 0;
            }
            if (String.valueOf(Integer.MIN_VALUE).length() < matchStr.length()) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.max(Integer.MIN_VALUE, Long.parseLong(matchStr));
        } else {
            matchStr = matchStr.replaceAll("^[0]*", "");
            if (matchStr.length() <= 0) {
                return 0;
            }
            if (String.valueOf(Integer.MAX_VALUE).length() < matchStr.length()) {
                return Integer.MAX_VALUE;
            }
            return (int) Math.min(Integer.MAX_VALUE, Long.parseLong(matchStr));
        }

    }

    /**
     * 遍历找数字
     * @param str
     * @return
     */
    static int myAtoi2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        final char space = ' ';;
        final char plus = '+';
        final char minus = '-';
        final char zero = '0';
        boolean isNegative = false;
        char[] chars = str.toCharArray();
        char[] tmpArray = new char[chars.length + 1];

        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (idx == 0 && c == space) {
                continue;
            }
            if (idx > 11) {
                break;
            }

            if (idx == 0) {
                if (minus == c) {
                    isNegative = true;
                    tmpArray[idx] = c;
                    idx = idx + 1;
                    continue;
                }

                if (plus == c) {
                    tmpArray[idx] = c;
                    idx = idx + 1;
                    continue;
                }

                if (Character.isDigit(c)) {
                    tmpArray[idx] = plus;
                    idx = idx + 1;
                    if (zero != c) {
                        tmpArray[idx] = c;
                        idx = idx + 1;
                    }
                    continue;
                }
                break;
            }
            if (idx == 1) {
                if (zero == c) {
                    continue;
                }
            }

            if (!Character.isDigit(c)) {
                break;
            }

            tmpArray[idx] = c;
            idx = idx + 1;
        }


        if (idx <= 1) {
            return 0;
        }

        char[] numbers = new char[idx];
        System.arraycopy(tmpArray, 0, numbers, 0, idx);

        if (isNegative) {
            return (int) Math.max(Integer.MIN_VALUE, Long.parseLong(String.valueOf(numbers)));
        } else {
            return (int) Math.min(Integer.MAX_VALUE, Long.parseLong(String.valueOf(numbers)));
        }
    }

    /**
     * 遍历+直接计算
     * @param str
     * @return
     */
    static int myAtoi3(String str) {
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MIN_VALUE);
        System.out.println(myAtoi2("20000000000000000000"));

//        System.out.println(String.valueOf(Integer.MAX_VALUE).length());
//        System.out.println(String.valueOf(Integer.MIN_VALUE).length());
//        System.out.println(Long.valueOf("99999999999"));
//
//        System.out.println("+".charAt(0));
    }


}

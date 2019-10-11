package me.lzb.algroithm.leetcode.n8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by egan on 19/10/11
 */
class Solution {
    public static int myAtoi(String str) {

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


    public static void main(String[] args) {
//        System.out.println(Integer.MIN_VALUE);
        System.out.println(myAtoi("  0000000000012345678"));
    }


}

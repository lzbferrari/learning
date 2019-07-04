package me.lzb.algroithm.leetcode.n1044;

import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。
 * <p>
 * 返回任何具有最长可能长度的重复子串。（如果 S 不含重复子串，那么答案为 ""。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："banana"
 * 输出："ana"
 * 示例 2：
 * <p>
 * 输入："abcd"
 * 输出：""
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= S.length <= 10^5
 * S 由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-duplicate-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * Created by egan on 19/6/17
 */
public class Solution {

    public String longestDupSubstring(String S) {

        String result = "";
        if (S == null || S.length() < 2) {
            return result;
        }

        int left = 0;
        int right = S.length();

        int l = getLen(left, right);

        while (l > 0) {
            String sss = getRepeatStr(S, l);
            if (sss.equals("")) {
                right = l;
            } else {
                result = sss;
                left = l;
            }
            l = getLen(left, right);

        }
        return result;
    }


    private String getRepeatStr(String s, int length) {
        Map<String, String> map = new HashMap<>();
        int left = 0;
        int right = length;

        while (right <= s.length()) {
            String xx = s.substring(left, right);

            if (map.containsKey(xx)) {
                return xx;
            } else {
                map.put(xx, null);
            }
            left++;
            right++;
        }

        return "";
    }


    private int getLen(int left, int right) {
        if (left + 1 >= right) {
            return -1;
        }

        int a = (right - left) % 2;
        if (a == 0) {
            return (right - left) / 2 + left;
        } else {
            return (right - 1 - left) / 2 + left;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "banana";
        System.out.println(solution.longestDupSubstring(s));
    }

}

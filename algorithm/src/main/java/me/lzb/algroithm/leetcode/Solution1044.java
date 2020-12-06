package me.lzb.algroithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
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
public class Solution1044 {

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
        Solution1044 solution = new Solution1044();
        String s = "banana";
        System.out.println(solution.longestDupSubstring(s));
    }


    /*
   Rabin-Karp with polynomial rolling hash.
       Search a substring of given length
       that occurs at least 2 times.
       Return start position if the substring exits and -1 otherwise.
       */
    public int search(int L, int a, long modulus, int n, int[] nums) {
        // compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < L; ++i) h = (h * a + nums[i]) % modulus;

        // already seen hashes of strings of length L
        HashSet<Long> seen = new HashSet();
        seen.add(h);
        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (seen.contains(h)) return start;
            seen.add(h);
        }
        return -1;
    }

    public String longestDupSubstringAnswer(String S) {
        int n = S.length();
        // convert string to array of integers
        // to implement constant time slice
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) nums[i] = (int) S.charAt(i) - (int) 'a';
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long) Math.pow(2, 32);

        // binary search, L = repeating string length
        int left = 1, right = n;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, modulus, n, nums) != -1) left = L + 1;
            else right = L;
        }

        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }

}

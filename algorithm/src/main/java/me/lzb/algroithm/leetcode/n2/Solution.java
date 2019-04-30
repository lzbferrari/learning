package me.lzb.algroithm.leetcode.n2;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author LZB
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //个位的计算
        int sum1 = l1.val + l2.val;
        int add = 0;
        if (sum1 >= 10) {
            add = 1;
            sum1 = sum1 % 10;
        }

        ListNode result = new ListNode(sum1);

        ListNode next1 = l1.next;
        ListNode next2 = l2.next;

        ListNode tmp = result;

        while (next1 != null || next2 != null || add > 0) {
            int v1 = 0;
            int v2 = 0;
            if (next1 != null) {
                v1 = next1.val;
                next1 = next1.next;
            }


            if (next2 != null) {
                v2 = next2.val;
                next2 = next2.next;
            }

            int s = v1 + v2 + add;
            if (s >= 10) {
                add = 1;
                s = s % 10;
            } else {
                add = 0;
            }

            ListNode n = new ListNode(s);
            tmp.next = n;
            tmp = n;
        }

        return result;

    }


}

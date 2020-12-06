package me.lzb.algroithm.leetcode;


/**
 * 翻转一棵二叉树
 *
 * @author LZB
 */
class Solution226 {
    /**
     * 从上到下，递归替换左和右子节点
     *
     * @param root
     * @return
     */
    TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode l = root.left;
        TreeNode r = root.right;

        root.left = r;
        root.right = l;

        if (l != null) {
            invertTree(l);
        }

        if (r != null) {
            invertTree(r);
        }

        return root;
    }


    /**
     * @author LZB
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

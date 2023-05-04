package com.brian.offer.offer54TheKthNodeInBst;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;

        // 倒序的 中序遍历
        dfs(root);
        return res;

    }
    public void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.right);
        if (k == 0)
            return;
        k--;
        if (k == 0) {
            res = root.val;
        }

        dfs(root.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

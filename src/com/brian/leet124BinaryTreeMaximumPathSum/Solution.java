package com.brian.leet124BinaryTreeMaximumPathSum;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。[重点]
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 * 链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        maxValue(root);
        return res;
    }

    public int maxValue(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = Math.max(maxValue(root.left), 0);
        int rightMax = Math.max(maxValue(root.right), 0);
        // 此处记录 左右子树 + 当前节点的值，但是返回的时候只能返回其中1只子树+curValue的值，因为【同一个节点在一条路径序列中 至多出现一次】
        res = Math.max(leftMax + rightMax + root.val, res);

        return Math.max(leftMax, rightMax) + root.val;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

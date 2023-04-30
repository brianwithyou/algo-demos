package com.brian.offer.offer55_1MaximumDepthOfBinaryTree;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 提示：
 * 节点总数 <= 10000
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        int leftMax = 1 + maxDepth(root.left);
        int rightMax = 1 + maxDepth(root.right);
        return Math.max(leftMax, rightMax);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

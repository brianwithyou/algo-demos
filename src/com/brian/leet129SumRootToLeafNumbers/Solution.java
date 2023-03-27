package com.brian.leet129SumRootToLeafNumbers;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 *
 * 链接：https://leetcode.cn/problems/sum-root-to-leaf-numbers
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    /**
     * 本题先使用数据，然后递归
     * 有的问题需要先递归，然后使用数据
     */
    private int sumNumbers(TreeNode root, int sum) {

        if (root == null)
            return 0;

        if (isLeaf(root))
            return sum * 10 + root.val;

        sum = sum * 10 + root.val;

        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }

    public boolean isLeaf(TreeNode root) {
        if (root == null)
            return false;
        return root.left == null && root.right == null;
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


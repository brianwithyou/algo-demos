package com.brian.leet226InvertBinaryTree;

/**
 * 反转二叉树
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode rightNode = root.right;

        root.right = invertTree(root.left);
        root.left = invertTree(rightNode);

        return root;

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

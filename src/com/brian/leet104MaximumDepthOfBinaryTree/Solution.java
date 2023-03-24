package com.brian.leet104MaximumDepthOfBinaryTree;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {

    int res = 0;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        res = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        return res;
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

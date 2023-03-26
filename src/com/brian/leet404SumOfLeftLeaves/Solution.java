package com.brian.leet404SumOfLeftLeaves;

import com.sun.source.tree.Tree;

/**
 * 404. Sum of Left Leaves
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 *
 * 链接：https://leetcode.cn/problems/sum-of-left-leaves
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively(分别地，分别是9和15，通常只用于写作中).
 *
 * respectively(分别地，分别是9和15，通常只用于写作中)
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && isLeaf(root.left))
            return root.left.val + sumOfLeftLeaves(root.right);
        if (root.left != null && !isLeaf(root.left))
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        // left == null
        return sumOfLeftLeaves(root.right);
    }

    /**
     * 直接左子树与右子树相加
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null)
            return 0;
        // 左右子树的结果相加，如果左子树是叶子结点，加上左子树的值
        return sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right) + (isLeaf(root.left) ? root.left.val : 0);
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

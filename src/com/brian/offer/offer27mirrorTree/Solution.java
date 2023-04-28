package com.brian.offer.offer27mirrorTree;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode leftTree = mirrorTree(root.left);
        TreeNode rightTree = mirrorTree(root.right);

        root.left = rightTree;
        root.right = leftTree;
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

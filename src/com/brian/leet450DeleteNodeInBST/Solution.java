package com.brian.leet450DeleteNodeInBST;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 
 *
 * 链接：https://leetcode.cn/problems/delete-node-in-a-bst
 * @author : brian
 * @since 0.1
 */
public class Solution {

    /**
     * 需要把所有的情况考虑清楚
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // root不等于key情况
        if (root == null)
            return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        // root.val == key
        //  1. left == null
        //  2. right == null
        //  3. left != null && right != null
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;
        // left != null && right != null(找到successor)
        TreeNode successor = root.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        // root更换为successor
        TreeNode rightTree = deleteNode(root.right, successor.val);
        successor.right = rightTree;
        successor.left = root.left;
        return successor;
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

package com.brian.leet230KthSmallestElementInBST;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    /**
     * 中序遍历
     */
    public int kthSmallest(TreeNode root, int k) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            k--;
            if (k == 0) {
                return pop.val;
            }
            root = pop.right;
        }
        throw new RuntimeException("there is no solution.");
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

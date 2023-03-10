package com.brian.leet103BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * @see com.brian.leet102BinaryTreeLevelOrderTraversal.Solution
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean fromRight = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {

                TreeNode poll = queue.poll();

                if (fromRight) {
                    temp.addFirst(poll.val);
                } else {
                    temp.addLast(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }

            }

            fromRight = !fromRight;

            res.add(temp);
        }
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

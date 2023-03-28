package com.brian.leet113PathSum2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 * 链接：https://leetcode.cn/problems/path-sum-ii
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    /**
     * 方法1：直接原函数递归, 二叉树直接使用此函数的返回值 递归
     *
     * 方法2：递归 path，定义全局变量res。 创建dfs()函数 递归的创建path，并往res中添加path
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return new ArrayList<>();

        if (isLeaf(root) && root.val == targetSum) {
            res.add(new ArrayList<>(){{add(root.val);}});
            return res;
        }

        List<List<Integer>> leftRes = pathSum(root.left, targetSum - root.val);
        for (int i = 0; i < leftRes.size(); i++) {
            List<Integer> temList = new ArrayList<>();
            temList.add(root.val);
            temList.addAll(leftRes.get(i));
            res.add(temList);
        }
        List<List<Integer>> rightRes = pathSum(root.right, targetSum - root.val);
        for (int i = 0; i < rightRes.size(); i++) {
            List<Integer> temList = new ArrayList<>();
            temList.add(root.val);
            temList.addAll(rightRes.get(i));
            res.add(temList);
        }
        return res;
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

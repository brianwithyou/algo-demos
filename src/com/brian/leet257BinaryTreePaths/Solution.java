package com.brian.leet257BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        if (isLeaf(root)) {
            res.add(String.valueOf(root.val));
            return res;
        }

        // 先递归  再执行逻辑？
        List<String> leftStrs = binaryTreePaths(root.left);
        for (int i = 0; i < leftStrs.size(); i++) {
            res.add(root.val + "->" + leftStrs.get(i));
        }

        List<String> rightStrs = binaryTreePaths(root.right);
        for (int i = 0; i < rightStrs.size(); i++) {
            res.add(root.val + "->" + rightStrs.get(i));
        }
        return res;
    }

    private boolean isLeaf(TreeNode root) {
        if (root == null)
            return false;
        return root.left == null && root.right == null;
    }

    public class TreeNode {
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

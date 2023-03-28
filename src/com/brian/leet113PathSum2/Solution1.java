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
 * 提示：
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @author : brian
 * @since 0.1
 */
public class Solution1 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        if (isLeaf(root) && root.val == targetSum) {
            res.add(new ArrayList<>(){{add(root.val);}});
            return res;
        }

        List<List<Integer>> leftRes = pathSum(root.left, targetSum - root.val);
        for (int i = 0; i < leftRes.size(); i++) {
            List<Integer> list = leftRes.get(i);
            list.add(0, root.val);
            res.add(list);
        }
        List<List<Integer>> rightRes = pathSum(root.right, targetSum - root.val);
        for (int i = 0; i < rightRes.size(); i++) {
            List<Integer> list = rightRes.get(i);
            list.add(0, root.val);
            res.add(list);
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

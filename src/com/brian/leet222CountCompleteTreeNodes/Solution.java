package com.brian.leet222CountCompleteTreeNodes;

import java.util.ArrayList;
import java.util.List;

/**
 * 222. 完全二叉树的节点个数
 *
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int countNodes(TreeNode root) {

        List<TreeNode> nodes = new ArrayList<>();
        countNodes(root, nodes);
        return nodes.size();
    }

    private void countNodes(TreeNode root, List<TreeNode> nodes) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            nodes.add(root);
            return;
        }
        nodes.add(root);
        countNodes(root.left, nodes);
        countNodes(root.right, nodes);
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

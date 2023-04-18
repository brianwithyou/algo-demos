package com.brian.leet1026MaxDiffBetweenNodeAndAncestor;

/**
 * 1026. 节点与其祖先之间的最大差值
 * 给定二叉树的根节点root，找出存在于 不同 节点A 和B之间的最大值 V，其中V = |A.val - B.val|，且A是B的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 *
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 *
 * 提示：
 *
 * 树中的节点数在 2 到 5000 之间。
 * 0 <= Node.val <= 105
 *
 * 链接：https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor
 *
 * Time Complexity O(n^2)
 * 有O(n)的解决方法，参考Solution1
 *
 * @author : brian
 * @since 0.1
 */
public class Solution1 {

    int diff = Integer.MIN_VALUE;

    /**
     * 思路：找每条深度 路径上的 min 和max
     * 因为每条深度路径上的节点 必定是 ancestor or child
     */
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val);
    }
    public int maxAncestorDiff(TreeNode root, int min, int max) {
        if (root == null)
            return 0;
        diff = Math.max(Math.abs(min - root.val), Math.abs(max - root.val));
        // 每次更新本条路径上的 min 和max
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        diff = Math.max(diff, maxAncestorDiff(root.left, min, max));
        diff = Math.max(diff, maxAncestorDiff(root.right, min, max));

        return diff;
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(3);

        int i = new Solution1().maxAncestorDiff(root);
        System.out.println(i);

    }

}

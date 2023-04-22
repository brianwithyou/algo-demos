package com.brian.offer26SubStructureOfTree;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *     4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 链接：https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isContainByRootOfA(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    public boolean isContainByRootOfA(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return true;
        if (A == null)
            return false;
        // 注意 这里很重要，如果A不空，B为空，说明A包含B了
        if (B == null)
            return true;

        if (A.val != B.val) {
            return false;
        }

        boolean leftSame = isContainByRootOfA(A.left, B.left);
        boolean rightSame = isContainByRootOfA(A.right, B.right);
        return leftSame && rightSame;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        // false
//        TreeNode a = new TreeNode(1);
//        a.left = new TreeNode(0);
//        a.right = new TreeNode(1);
//        a.left.left = new TreeNode(-4);
//        a.left.right = new TreeNode(-3);
//
//        TreeNode b = new TreeNode(1);
//        b.left = new TreeNode(-4);

        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(4);
        a.right = new TreeNode(5);
        a.left.left = new TreeNode(1);
        a.left.right = new TreeNode(2);

        TreeNode b = new TreeNode(4);
        b.left = new TreeNode(1);
        boolean subStructure = new Solution().isSubStructure(a, b);
        System.out.println(subStructure);
    }

}

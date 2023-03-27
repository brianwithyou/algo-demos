package com.brian.leet437PathSum3;

/**
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 链接：https://leetcode.cn/problems/path-sum-iii
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null)
            return 0;

        int res = 0;
        // 总路径数 = 包含此节点的路径数 + 不包含此节点的路径数
        res += findPath(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);

        return res;
    }

    /**
     * 寻找和为sum的路径，并且包含root节点
     * 测试用例 [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000] 0
     * 会导致减法溢出，需要用long
     * ret += rootSum(root.left, targetSum - val); 一直执行造成的，
     * 0-1000000000-1000000000-294967296-1000000000 == 1000000000
     *
     */
    private int findPath(TreeNode root, long targetSum) {
        // 不能找到叶子结点，需要找到null节点
        if (root == null)
            return 0;
        int res = 0;
        // 不能直接返回，因为可能存在负数
        if (root.val == targetSum) {
            res++;
        }
        res += findPath(root.left, targetSum - root.val);
        res += findPath(root.right, targetSum - root.val);
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

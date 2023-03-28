package com.brian.leet108ConvertSortedArrayToBinarySearchTree;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    /**
     * 转为二分搜索树可以选取任意值作为 root
     * 转为平衡的二分搜索树只能选取mid元素作为root，可以取靠右的mid，也可以取靠做的mid
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {

        if (left == right)
            return new TreeNode(nums[left]);

        if (left > right)
            return null;

        // 选取的靠左的 中间节点
//        int mid = left + (right - left) / 2;
        /// 选取靠右的 中间节点
        int mid = left + (right - left + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
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

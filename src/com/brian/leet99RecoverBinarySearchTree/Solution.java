package com.brian.leet99RecoverBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树[medium]
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 *
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 *
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 *
 * 链接：https://leetcode.cn/problems/recover-binary-search-tree
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    List<Integer> res = new ArrayList<>();
    List<Integer> reversed = new ArrayList<>();

    /**
     * time complexity: O(n)
     * space complexity: O(n)
     *
     * 进阶：能否用 O(1)的空间复杂度实现
     * Follow Up(跟进): A solution using O(n) space is pretty straight-forward. Could you devise(发明) a constant O(1) space solution?
     * 
     * Follow-Up Solution:
     * 使用 Morris中序遍历，迭代方式遍历，
     * 找到processor前驱节点，将processor的right指向curNode，
     * if(processor.right != null) 已经遍历过了，然后遍历cur.right,
     * else 将processor的right指向curNode
     *
     */
    public void recoverTree(TreeNode root) {

        inorder(root);

        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) < res.get(i - 1)) {
                reversed.add(res.get(i - 1));
                break;
            }
        }
        for (int i = res.size() - 2; i >= 0; i--) {
            if (res.get(i) > res.get(i + 1)) {
                reversed.add(res.get(i + 1));
                break;
            }
        }
        recover(root);
    }
    public void recover(TreeNode root) {
        if (root == null)
            return;
        assert reversed.size() == 2;

        Integer integer1 = reversed.get(0);
        Integer integer2 = reversed.get(1);

        if (root.val == integer1) {
            root.val = integer2;
        } else if (root.val == integer2) {
            root.val = integer1;
        }

        recover(root.left);
        recover(root.right);
    }
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
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

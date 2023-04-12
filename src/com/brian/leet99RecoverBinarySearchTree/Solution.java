package com.brian.leet99RecoverBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {

    List<Integer> res = new ArrayList<>();
    List<Integer> reversed = new ArrayList<>();

    // 3 2 1
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

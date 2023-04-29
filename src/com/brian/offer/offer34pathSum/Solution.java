package com.brian.offer.offer34pathSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {

        pathSum(root, target, new LinkedList<>());
        return res;
    }

    public void pathSum(TreeNode root, int target, LinkedList<Integer> path) {
        if (root == null)
            return;

        path.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                res.add(new ArrayList<>(path));
                // 此处不能return ，因为需要removeLast()
//                return;
            }
        }

        pathSum(root.left, target - root.val, path);
        pathSum(root.right, target - root.val, path);
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);


        List<List<Integer>> lists = new Solution().pathSum(root, 22);
        System.out.println(lists);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

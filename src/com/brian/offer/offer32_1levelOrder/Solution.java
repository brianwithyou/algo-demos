package com.brian.offer.offer32_1levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            res.add(poll.val);

            if (poll.left != null)
                queue.add(poll.left);
            if (poll.right != null)
                queue.add(poll.right);
        }
        return res.stream().mapToInt(i -> i).toArray();

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

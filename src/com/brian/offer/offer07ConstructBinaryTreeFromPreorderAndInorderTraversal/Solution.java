package com.brian.offer.offer07ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {
    // inorder中 value -> index
    private final Map<Integer, Integer> valToIdx = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIdx.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * @param preorderLeft  preorderLef 索引
     * @param preorderRight preorderRight 索引
     * @param inorderLeft   inorderLeft索引
     * @param inorderRight  inorderRight索引
     * @return 构建结果
     */
    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight)
            return null;

        int rootVal = preorder[preorderLeft];
        Integer rootIdx = valToIdx.get(rootVal);
        // 获取左子树节点数量
        int leftNodeCount = rootIdx - inorderLeft;

        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.left = buildTree(preorder, inorder
                , preorderLeft + 1, preorderLeft + leftNodeCount, inorderLeft, rootIdx - 1);

        rootNode.right = buildTree(preorder, inorder
                , preorderLeft + leftNodeCount + 1, preorderRight, rootIdx + 1, inorderRight);

        return rootNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

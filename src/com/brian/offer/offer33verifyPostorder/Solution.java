package com.brian.offer.offer33verifyPostorder;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 提示：
 * 数组长度 <= 1000
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }
    public boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right)
            return true;

        int root = postorder[right];
        int rightFirst = right;
        for (int i = left; i < right; i++) {
            if (postorder[i] > root) {
                if (rightFirst == right)
                    rightFirst = i;
            }
            if (i > rightFirst && postorder[i] < root) {
                return false;
            }
        }
        return verifyPostorder(postorder, left, rightFirst - 1) && verifyPostorder(postorder, rightFirst, right - 1);
    }

    public static void main(String[] args) {
//        boolean b = new Solution().verifyPostorder(new int[]{1, 6, 3, 2, 5});   // false
//        boolean b = new Solution().verifyPostorder(new int[]{1,3,2,6,5});     // true
        boolean b = new Solution().verifyPostorder(new int[]{1,2,5,10,6,9,4,3});    // false
//        boolean b = new Solution().verifyPostorder(new int[]{5, 4, 3, 2, 1});    // true
//        boolean b = new Solution().verifyPostorder(new int[]{1,2,5,10,6,9,4,3});    // false
        System.out.println(b);
    }
}

package com.brian.leet300LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列index是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        // 可以将res放入原来的for循环中，为了代码好理解，放在此处
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] data = new int[]{10,9,2,5,3,7,101,18}; // 4
        int[] data = new int[]{1,3,6,7,9,4,10,5,6}; // 6

        int i = new Solution().lengthOfLIS(data);
        System.out.println(i);
    }
}

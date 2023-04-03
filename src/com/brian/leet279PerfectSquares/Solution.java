package com.brian.leet279PerfectSquares;

import java.util.Arrays;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * 链接：https://leetcode.cn/problems/perfect-squares
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int numSquares(int n) {

        // n 的result
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1;i <= n; i++) {
            for (int j = 0; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = new Solution().numSquares(13); // 2
//        int i = new Solution().numSquares(12); // 3
//        int i = new Solution().numSquares(2); // 2
        System.out.println(i);
    }

}

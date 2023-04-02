package com.brian.leet343IntegerBreak;

import java.util.Arrays;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 *
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 2 <= n <= 58
 *
 * @author : brian
 * @since 0.1
 */
public class Solution2_DP {

    public int integerBreak(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = max3(dp[i], j * (i - j), j * dp[i - j]);
            }
        }
        return dp[n];
    }
    private int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }

    public static void main(String[] args) {
        int i = new Solution2_DP().integerBreak(10);
        System.out.println(i);
    }
}


package com.brian.leet64MinimumPathSum;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Input: grid = [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * 链接：https://leetcode.cn/problems/minimum-path-sum
 * @author : brian
 * @since 0.1
 */
public class Solution2_DP {
    int m, n;
    int[][] dp;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 1000);
        }
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i - 1][j]);
                if (j - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i][j - 1]);

                System.out.println(dp[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
    public boolean inArea(int startX, int startY) {
        return startX >= 0 && startX < m && startY >= 0 && startY < n;
    }

    public static void main(String[] args) {
        int i = new Solution2_DP().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(i);
    }
}

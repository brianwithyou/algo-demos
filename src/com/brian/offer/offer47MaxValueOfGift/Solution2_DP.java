package com.brian.offer.offer47MaxValueOfGift;

import java.util.Arrays;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 链接：https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof
 *
 * @author : brian
 * @since 0.1
 */
public class Solution2_DP {
    int m, n;
    int[][] dp;
    public int maxValue(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], - 1);
        }
        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + grid[i][j]);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + grid[i][j]);
                }
                System.out.printf("dp[%s][%s] = %s\n", i, j, dp[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int i = new Solution2_DP().maxValue(data);
        System.out.println(i);
    }
    public boolean inArea(int startX, int startY) {
        return startX >= 0 && startX < m && startY >= 0 && startY < n;
    }
}

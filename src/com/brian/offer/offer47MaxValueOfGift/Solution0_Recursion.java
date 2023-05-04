package com.brian.offer.offer47MaxValueOfGift;

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
public class Solution0_Recursion {
    int m, n;
    public int maxValue(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        return maxValue(grid, 0, 0);
    }
    // 超时
    public int maxValue(int[][] grid, int startX, int startY) {

        if (startX == m - 1 && startY == n - 1)
            return grid[startX][startY];

        int res = 0;
        if (inArea(startX + 1, startY))
            res = grid[startX][startY] + maxValue(grid, startX + 1, startY);
        if (inArea(startX, startY + 1))
            res = Math.max(res, grid[startX][startY] + maxValue(grid, startX, startY + 1));
        return res;
    }

    public boolean inArea(int startX, int startY) {
        return startX >= 0 && startX < m && startY >= 0 && startY < n;
    }
}

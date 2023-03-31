package com.brian.leet64MinimumPathSum;

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
public class Solution0_Recursion_Timeout {
    int m, n;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        return minPathSum(grid, 0, 0);
    }
    public int minPathSum(int[][] grid, int startX, int startY) {
        if (startX == m - 1 && startY == n - 1)
            return grid[startX][startY];

        int sum = Integer.MAX_VALUE;
        if (inArea(startX + 1, startY)) {
            sum = grid[startX][startY] + minPathSum(grid, startX + 1, startY);
        }
        if (inArea(startX, startY + 1)) {
            sum = Math.min(sum, grid[startX][startY] + minPathSum(grid, startX, startY + 1));
        }
//        System.out.printf("sum(%s, %s) = %s\n", startX, startY, sum);
        return sum;
    }
    public boolean inArea(int startX, int startY) {
        return startX >= 0 && startX < m && startY >= 0 && startY < n;
    }

    public static void main(String[] args) {
        int i = new Solution0_Recursion_Timeout().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(i);
    }
}

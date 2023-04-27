package com.brian.offer.offer29spiralOrder;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * @author : brian
 * @since 0.1
 */
public class Solution {

    private int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int m, n;

    public int[] spiralOrder(int[][] matrix) {
        m = matrix.length;
        if (m == 0)
            return new int[0];
        n = matrix[0].length;

        int direction = 0;
        int total = m * n;
        int[] res = new int[total];
        boolean[][] visited = new boolean[m][n];
        int row = 0, col = 0;
        for (int i = 0; i < total; i++) {
            res[i] = matrix[row][col];
            visited[row][col] = true;

            int nextRow = row + directions[direction][0];
            int nextCol = col + directions[direction][1];
            if (!inArea(nextRow, nextCol) || visited[nextRow][nextCol]) {
                direction = (direction + 1) % 4;
            }
            row = row + directions[direction][0];
            col = col + directions[direction][1];
        }
        return res;
    }

    private boolean inArea(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        System.out.println(Arrays.toString(ints));
    }
}

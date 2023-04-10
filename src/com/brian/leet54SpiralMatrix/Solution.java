package com.brian.leet54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 输入：matrix = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 输入：matrix = [
 * [1,2,3,4],
 * [5,6,7,8],
 * [9,10,11,12]
 * ]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    int m, n;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;

        int m = matrix.length;
        int n = matrix[0].length;
        this.m = m;
        this.n = n;

        int total = m * n;
        // 方向必须是 右 下 左 上
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int curRow = 0;
        int curColumn = 0;
        boolean[][] visited = new boolean[m][n];

        int directionIdx = 0;
        for (int i = 0; i < total; i++) {

            res.add(matrix[curRow][curColumn]);
            visited[curRow][curColumn] = true;

            int nextRow = curRow + directions[directionIdx][0];
            int nextColumn = curColumn + directions[directionIdx][1];
            if (!inArea(nextRow, nextColumn) || visited[nextRow][nextColumn]) {
                directionIdx = (directionIdx + 1) % 4;
            }
            curRow = curRow + directions[directionIdx][0];
            curColumn = curColumn + directions[directionIdx][1];
        }
        return res;
    }

    private boolean inArea(int nextRow, int nextColumn) {
        return nextRow >= 0 && nextRow < m && nextColumn >= 0 && nextColumn < n;
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(list);
    }
}

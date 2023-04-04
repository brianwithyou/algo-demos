package com.brian.leet130SurroundedRegions;

import java.util.Arrays;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 输入：board = [
 * ["X","X","X","X"],
 * ["X","O","O","X"],
 * ["X","X","O","X"],
 * ["X","O","X","X"]
 * ]
 * 输出：[
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","O","X","X"]
 * ]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的''O''都不会被填充为''X'。
 * 任何不在边界上，或不与边界上的''O''相连的''O''最终都会被填充为''X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 链接：https://leetcode.cn/problems/surrounded-regions
 * 
 * @author : brian
 * @since 0.1
 */
public class Solution {
    int m, n;
    int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                solve(board, i, 0);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                solve(board, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                solve(board, 0, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[m - 1][i] == 'O') {
                solve(board, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void solve(char[][] board, int startX, int startY) {
        if (!inArea(startX, startY) || board[startX][startY] != 'O') {
            return;
        }
        // 把与所有的O 变为A
        board[startX][startY] = 'A';

        for (int i = 0; i < directions.length; i++) {
            int newX = startX + directions[i][0];
            int newY = startY + directions[i][1];
            solve(board, newX, newY);
        }
    }

    private boolean inArea(int startX, int startY) {
        return startX >= 0 && startX < m && startY >= 0 && startY < n;
    }

    public static void main(String[] args) {
        char[][] data = new char[][] {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        new Solution().solve(data);

        System.out.println(Arrays.deepToString(data));
    }
}

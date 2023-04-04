package com.brian.leet200NumberOfIslands;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * 输入：grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出：1
 * <p>
 * 输入：grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出：3
 *
 * @author : brian
 * @since 0.1
 */
public class Solution1 {

    /**
     * dfs算法，DFS
     * 深度优先算法
     */
    int m, n;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int startX, int startY) {

        if (!inArea(startX, startY) || grid[startX][startY] != '1') {
            return;
        }
        grid[startX][startY] = '2';
        for (int i = 0; i < directions.length; i++) {
            int newX = startX + directions[i][0];
            int newY = startY + directions[i][1];
            dfs(grid, newX, newY);
        }
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
//       char[][] grid = {
//               {'1','1','1','1','0'},
//               {'1','1','0','1','0'},
//               {'1','1','0','0','0'},
//               {'0','0','0','0','0'}
//       };
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int i = new Solution1().numIslands(grid);
        System.out.println(i);

    }
}

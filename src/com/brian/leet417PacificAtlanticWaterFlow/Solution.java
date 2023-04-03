package com.brian.leet417PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。“太平洋”处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * <p>
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵heights，heights[r][c]表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * <p>
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * <p>
 * 返回网格坐标 result的 2D 列表 ，其中result[i] = [ri, ci]表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
 * 输入: heights = [
 * [1,2,2,3,(5)],
 * [3,2,3,(4),(4)],
 * [2,4,(5),3,1],
 * [(6),(7),1,4,5],
 * [(5),1,1,2,4]
 * ]
 * <p>
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * 括号中的即答案
 * <p>
 * 链接：https://leetcode.cn/problems/pacific-atlantic-water-flow
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {


    boolean[][] pacific;
    boolean[][] atlantic;
    int m, n;

    // 从边界开始找
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        m = heights.length;
        n = heights[0].length;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            dfs(heights, 0, i, pacific);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, atlantic);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, m - 1, i, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    res.add(ans);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int startX, int startY, boolean[][] ocean) {
        if (ocean[startX][startY]) {
            return;
        }
        ocean[startX][startY] = true;

        if (inArea(startX + 1, startY) && heights[startX + 1][startY] >= heights[startX][startY]) {
            dfs(heights, startX + 1, startY, ocean);
        }
        if (inArea(startX - 1, startY) && heights[startX - 1][startY] >= heights[startX][startY]) {
            dfs(heights, startX - 1, startY, ocean);
        }
        if (inArea(startX, startY + 1) && heights[startX][startY + 1] >= heights[startX][startY]) {
            dfs(heights, startX, startY + 1, ocean);
        }
        if (inArea(startX, startY - 1) && heights[startX][startY - 1] >= heights[startX][startY]) {
            dfs(heights, startX, startY - 1, ocean);
        }
    }

    private boolean inArea(int startX, int startY) {
        return startX >= 0 && startX < m && startY >= 0 && startY < n;
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> lists = new Solution().pacificAtlantic(data);
        System.out.println(lists);
    }

}

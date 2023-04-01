package com.brian.leet51N_Queens;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * <p>
 * Input: n = 4
 * Output: [
 * [".Q..",
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",
 * "Q...",
 * "...Q",
 * ".Q.."]]
 * <p>
 * [.Q..,
 * Q...,
 * ...Q,
 * ..Q.]
 * <p>
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * <p>
 * 1 <= n <= 9
 * 链接：https://leetcode.cn/problems/n-queens
 *
 * @author : brian
 * @since 0.1
 */
public class Solution_Recursion {
    // (0, 0) (0, 1) (0, 2) (0, 3)
    // (1, 0) (1, 1) (1, 2) (1, 3)
    // (2, 0) (2, 1) (2, 2) (2, 3)
    // (3, 0) (3, 1) (3, 2) (3, 3)
    boolean[] column;
    boolean[] dia1; // row + column
    boolean[] dia2; // index - j + n - 1

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        column = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];


        solveNQueens(n, 0, new ArrayList<>());

        return res;

    }

    // 搜索到了index行，从0开始， 要搜素n个
    public void solveNQueens(int n, int index, List<String> ans) {
        if (index == n) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!column[j] && !dia1[index + j] && !dia2[index - j + n - 1]) {

                column[j] = true;
                dia1[index + j] = true;
                dia2[index - j + n - 1] = true;

                // 此处可以提取出去，作为模板，然后  StringBuilder sb = new StringBuilder(template);
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    sb.append(".");
                }
                sb.replace(j, j + 1, "Q");
//                System.out.println(sb);
                ans.add(sb.toString());

                solveNQueens(n, index + 1, ans);

                ans.remove(ans.size() - 1);
                column[j] = false;
                dia1[index + j] = false;
                dia2[index - j + n - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution_Recursion().solveNQueens(4);
        for (int index = 0; index < lists.size(); index++) {
            System.out.println(lists.get(index));
        }

//        StringBuilder test = new StringBuilder("........");
//        test.replace(1, 2, "Q");
//        System.out.println(test);


    }
}

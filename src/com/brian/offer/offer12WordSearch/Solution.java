package com.brian.offer.offer12WordSearch;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * 输入：board = [
 * ["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    int m, n;
    boolean[][] visited;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int startX, int startY, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (!inArea(startX, startY)) {
            return false;
        }
//        System.out.printf("board[%s][%s]: %s, index: %s \n", startX, startY, board[startX][startY], word.substring(0, index + 1));
        if (board[startX][startY] == word.charAt(index) && !visited[startX][startY]) {
            visited[startX][startY] = true;
            for (int i = 0; i < directions.length; i++) {
                int newX = startX + directions[i][0];
                int newY = startY + directions[i][1];
                if (exist(board, newX, newY, word, index + 1)) {
                    return true;
                }
            }
            visited[startX][startY] = false;
        }
        return false;
    }

    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < m && newY >= 0 && newY < n;
    }

    public static void main(String[] args) {
//        char[][] data = new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        char[][] data = new char[][]{
//                {'A', 'B'},
//                {'C', 'D'}
//        };
//        boolean exist = new Solution().exist(data, "ABCCED");
//        boolean exist = new Solution().exist(data, "ABCD");

        char[][] data = new char[][]{
                {'A'},
        };
        boolean exist = new Solution().exist(data, "A");
        System.out.println(exist);
    }
}

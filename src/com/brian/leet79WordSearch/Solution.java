package com.brian.leet79WordSearch;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 输入：board =
 * [
 * ["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]
 * ], word = "ABCCED"
 * 输出：true
 *
 * 链接：https://leetcode.cn/problems/word-search
 * @author : brian
 * @since 0.1
 */
public class Solution {
    int edgeX, edgeY;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        edgeX = board.length;
        edgeY = board[0].length;
        visited = new boolean[edgeX][edgeY];

        for (int i = 0; i < edgeX; i++) {
            for (int j = 0; j < edgeY; j++) {
                if (exist(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word, int wordIndex, int startX, int startY) {
        if (wordIndex == word.length())
            return true;
        if (!inArea(startX, startY)) {
            return false;
        }

        if (board[startX][startY] == word.charAt(wordIndex) && !visited[startX][startY]) {
            visited[startX][startY] = true;
            boolean exist1 = exist(board, word, wordIndex + 1, startX + 1, startY);
            boolean exist2 = exist(board, word, wordIndex + 1, startX - 1, startY);
            boolean exist3 = exist(board, word, wordIndex + 1, startX, startY + 1);
            boolean exist4 = exist(board, word, wordIndex + 1, startX, startY - 1);
            if (exist1 || exist2 || exist3 || exist4)
                return true;
            visited[startX][startY] = false;
        }
        return false;
    }

    private boolean inArea(int startX, int startY) {
        if (startX < 0 || startX >= edgeX || startY < 0 || startY >= edgeY)
            return false;
        return true;
    }

    public static void main(String[] args) {
        char[][] test = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        boolean exist = new Solution().exist(test, "ABCCED");
        System.out.println(exist);
    }

}

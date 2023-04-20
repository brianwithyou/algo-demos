package com.brian.leet72EditDistance;

/**
 * 72. 编辑距离
 * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 示例1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 链接：https://leetcode.cn/problems/edit-distance
 * @author : brian
 * @since 0.1
 */
public class Solution1 {

    int[][] memory;
    public int minDistance(String word1, String word2) {
        memory = new int[word1.length()][word2.length()];

        return minDistance(word1, 0, word2, 0);

    }
    public int minDistance(String word1, int idx1, String word2, int idx2) {
        if (word1.length() == idx1) {
            return word2.length() - idx2;
        }
        if (word2.length() == idx2) {
            return word1.length() - idx1;
        }

        if (memory[idx1][idx2] != 0) {
            return memory[idx1][idx2];
        }

        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            return minDistance(word1, idx1 + 1, word2, idx2 + 1);
        }

        // 下一步替换
        int replaceMin = minDistance(word1, idx1 + 1, word2, idx2 + 1) + 1;
        int deleteMin = minDistance(word1, idx1 + 1, word2, idx2) + 1;
        int addMin = minDistance(word1, idx1, word2, idx2 + 1) + 1;

        int min = Math.min(replaceMin, Math.min(deleteMin, addMin));
        memory[idx1][idx2] = min;

        return min;
    }

    public static void main(String[] args) {
//        int i = new Solution().minDistance("horse", "ros"); // 3
//        int i = new Solution1().minDistance("horse", "ros"); // 3
        int i = new Solution().minDistance("intention", "execution"); // 5
        System.out.println(i);
    }
}

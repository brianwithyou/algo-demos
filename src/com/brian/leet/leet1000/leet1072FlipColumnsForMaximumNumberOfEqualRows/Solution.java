package com.brian.leet.leet1000.leet1072FlipColumnsForMaximumNumberOfEqualRows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1072. 按列翻转得到最大值等行数
 * 给定 m x n 矩阵 matrix 。
 *
 * 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。）
 *
 * 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。
 *
 * 输入：matrix = [[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 *
 * 输入：matrix = [[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 *
 * 输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] == 0 或 1
 * @author : brian
 * @since 0.1
 */
public class Solution {
    /**
     * TODO CVπ
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows/solution/an-lie-fan-zhuan-de-dao-zui-da-zhi-deng-teeig/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 本质是求 等价的行，如果一行可以反转以后 与另一行相等，
     * 那么这两行 反转一定的列数之后，一定能使得这两行 每行的元素都相等
     * 例如 1110 ， 0001 , 第二行 反转以后与第一行相等，那么 这两行反转 一定的列数之后，两行的元素 肯定是 行内元素相等的
     *
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '0');
            for (int j = 0; j < n; j++) {
                // 如果 matrix[i][0] 为 1，则对该行元素进行翻转
                arr[j] = (char) ('0' + (matrix[i][j] ^ matrix[i][0]));
            }
            String s = new String(arr);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }


}

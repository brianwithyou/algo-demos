package com.brian.leet1143LongestCommonSubsequence;

/**
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        if (text1.length() < 1 || text2.length() < 1) {
            return 0;
        }
        // dp[i][j]标识 text1(0,i) 和 text2(0,j)的最长公共子序列长度
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

//        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
//        dp[0][1] = text1.charAt(0) == text2.charAt(1) ? dp[0][0] + 1 : dp[0][0];
//        dp[1][0] = text1.charAt(1) == text2.charAt(0) ? dp[0][0] + 1 : dp[0][0];
        // 由于 text1[0] text2[0]都需要跟另一个子串遍历对比一遍，所以需要从0开始，可以多开辟1个数组长度
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
//        int i = new Solution().longestCommonSubsequence("abcde", "ace");
//        int i = new Solution().longestCommonSubsequence("bl", "yby");
        int i = new Solution().longestCommonSubsequence("ezupkr","ubmrapg");
        System.out.println(i);
    }
}

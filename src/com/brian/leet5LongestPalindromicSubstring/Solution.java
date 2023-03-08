package com.brian.leet5LongestPalindromicSubstring;

/**
 * Given a string s, return the longest palindromic substring in s.
 * 返回最长回文子串
 * @author : brian
 * @since 0.1
 */
public class Solution {

    /**
     * 1. 中心扩散算法
     * 2. 动态规划
     * 此为动态规划
     */
    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        int maxStart = 0;
        int maxEnd = 0;
        // dp[i][j]是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}

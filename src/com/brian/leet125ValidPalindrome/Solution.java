package com.brian.leet125ValidPalindrome;

import java.util.Locale;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 *
 * @link <a href=https://leetcode.cn/problems/valid-palindrome></a>
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public boolean isPalindrome(String s) {

        int start = 0, end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            if (!isAlpha(s.charAt(start))) {
                start++;
                continue;
            }
            if (!isAlpha(s.charAt(end))) {
                end--;
                continue;
            }
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 判断是否是字母或者数字
     */
    public boolean isAlpha(char c) {
//        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        boolean alpha = new Solution().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(alpha);

    }
}

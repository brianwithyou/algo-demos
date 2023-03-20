package com.brian.leet03lengthOfLongestSubstring;

import java.util.*;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @author : Brian
 * @since 0.1
 */
public class Solution1 {

    /**
     * 滑动窗口 左侧指针固定，右侧变动
     */
    public int lengthOfLongestSubstring(String s) {

        int right = -1;
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                right++;
                set.add(s.charAt(right));
            }
            res = Math.max(res, right - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "abcabcbb";
        Solution1 solution = new Solution1();
        int i = solution.lengthOfLongestSubstring(test);
        System.out.println(i);
    }
}
